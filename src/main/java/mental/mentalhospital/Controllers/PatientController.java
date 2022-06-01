package mental.mentalhospital.Controllers;

import mental.mentalhospital.Entities.Patient;
import mental.mentalhospital.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;
    @GetMapping("/")
    public String index(Model model){
        /*Registrations r = new Registrations(patientService.getClients(11),workoutsService.getWorkout(14));
        registrationsService.add(r);
        Workouts w = new Workouts("Fitnesas","30/04/2022",6,"sporto sale 1");
        workoutsService.add(w);*/
        model.addAttribute("clients", patientService.getAllClients());
        return "index";
    }
    @GetMapping("/new_client")
    public String clientNew(Model model){
        return "new_client";
    }
    @PostMapping("/new_client")
    public String addClient(@Valid @ModelAttribute Patient client, BindingResult result, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
                            @RequestParam("phone")String phone,  Model model){
        if (result.hasErrors()){
            return "/new_client";
        }
        client.setName(name);
        client.setPhone(phone);

        client.setSurname(surname);
        //Patient c = new Patient(name,surname,email,phone);
        patientService.addClients(client);
        return "redirect:/";
    }
    @GetMapping("/update_clients")
    public String clientNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("client",patientService.getClients(id));
        return "update_clients";
    }
    @PostMapping("/update_clients")
    public String clientUpdate(@ModelAttribute Patient c){
        patientService.updateClients(c);
        return "redirect:/";
    }
    @GetMapping("/delete_client")
    public String clientDelete(Model model, @RequestParam("id") Integer id){
        patientService.deleteClients(id);
        return "redirect:/";
    }
}
