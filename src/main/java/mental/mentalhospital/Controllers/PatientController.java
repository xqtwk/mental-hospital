package mental.mentalhospital.Controllers;

import mental.mentalhospital.Entities.Doctor;
import mental.mentalhospital.Entities.Patient;
import mental.mentalhospital.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    CityService cityService;
    @Autowired
    GenderService genderService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    RoomService roomService;
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    FileUploadController fileUploadController;
    @GetMapping("/patients")
    public String index(Model model){
        model.addAttribute("patients", patientService.getAllClients());
        return "patients";
    }
    @GetMapping("/addpatient")
    public String clientNew(Model model){
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("genders", genderService.getAllGenders());
        model.addAttribute("rooms", roomService.getAllClients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "addpatient";
    }
    @PostMapping("/addpatient")
    public String addClient(@Valid @ModelAttribute Patient patient,
                            BindingResult result,
                            @RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("phone")String phone,
                            @RequestParam("address") String address,
                            @RequestParam("birthDate") String birthDate,
                            @RequestParam("statement") String statement,
                            @RequestParam("treatment") String treatment,
                            @RequestParam("cityId") Integer cityId,
                            @RequestParam("genderId") Integer genderId,
                            @RequestParam("doctor") Integer doctor_ID,
                            @RequestParam("room") Integer roomId,
                            @RequestParam("description") MultipartFile description,
                            Model model){
        if (result.hasErrors()){
            model.addAttribute("cities", cityService.getAllCities());
            model.addAttribute("genders", genderService.getAllGenders());
            model.addAttribute("rooms", roomService.getAllClients());
            model.addAttribute("doctors", doctorService.getAllDoctors());
            return "addpatient";
        }
        System.out.println(doctor_ID);
        patient.setName(name);
        patient.setSurname(surname);
        patient.setPhone(phone);
        patient.setAddress(address);
        patient.setBirthDate(birthDate);
        patient.setTreatment(treatment);
        patient.setStatement(statement);
        patient.setCity(cityService.getCity(cityId));
        patient.setGender(genderService.getGender(genderId));
        patient.setDoctor(doctorService.getDoctors(doctor_ID));
        patient.setRoom(roomService.getClients(roomId));
        patient.setFilename(description.getOriginalFilename());
        patientService.addClients(patient);
        fileStorageService.store(description, patient.getId().toString());
        return "redirect:/patients";
    }
    @GetMapping("/editpatient")
    public String clientNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("patient",patientService.getClients(id));
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("genders", genderService.getAllGenders());
        model.addAttribute("rooms", roomService.getAllClients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "editpatient";
    }
    @PostMapping("/editpatient")
    public String clientUpdate(@ModelAttribute Patient c){
        patientService.updateClients(c);
        return "redirect:/patients";
    }
    @GetMapping("/deletepatient")
    public String clientDelete(Model model, @RequestParam("id") Integer id){
        patientService.deleteClients(id);
        return "redirect:/patients";
    }
    @GetMapping("/patient/{id}")
    @ResponseBody
    public ResponseEntity<Resource> getDescription(@PathVariable Integer id){
        Resource file = fileStorageService.loadFile(id.toString());
        Patient w = patientService.getClients(id);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+w.getFilename()+"\"")
                .body(file);
    }
}
