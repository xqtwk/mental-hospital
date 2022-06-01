package mental.mentalhospital.Controllers;

import mental.mentalhospital.Entities.Doctor;
import mental.mentalhospital.Repositories.DoctorRepository;
import mental.mentalhospital.Services.CityService;
import mental.mentalhospital.Services.DoctorService;
import mental.mentalhospital.Services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    CityService cityService;
    @Autowired
    GenderService genderService;
    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }
    @GetMapping("/doctorsadmin")
    public String doctorsadmin(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctorsadmin";
    }
    @GetMapping("/editdoctor")
    public String clientNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("genders", genderService.getAllGenders());
        model.addAttribute("client",doctorService.getDoctors(id));
        return "editdoctor";
    }
    @PostMapping("/editdoctor")
    public String clientUpdate(@ModelAttribute Doctor c,BindingResult result){
        doctorService.editDoctor(c);
        return "redirect:/doctorsadmin";
    }
    @GetMapping("/deletedoctor")
    public String clientDelete(Model model, @RequestParam("id") Integer id){
        doctorService.deleteDoctors(id);
        return "redirect:/doctorsadmin";
    }
}
