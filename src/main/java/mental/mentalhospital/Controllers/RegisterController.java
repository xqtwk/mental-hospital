package mental.mentalhospital.Controllers;

import mental.mentalhospital.Entities.Doctor;
import mental.mentalhospital.Services.CityService;
import mental.mentalhospital.Services.DoctorService;
import mental.mentalhospital.Services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    CityService cityService;

    @Autowired
    GenderService genderService;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("client", new Doctor());
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("genders", genderService.getAllGenders());
        return "register";
    }
    @PostMapping("/register")
    public String newClient(
            @Valid
            @ModelAttribute Doctor doctor,
            BindingResult result,
            @RequestParam("cityId") Integer cityId,
            @RequestParam("genderId") Integer genderId,
            Model model
    ) {
        if(result.hasErrors()) {
            model.addAttribute("cities", cityService.getAllCities());
            model.addAttribute("genders", genderService.getAllGenders());
            return "register";
        }
        doctor.setCity(cityService.getCity(cityId));
        doctor.setGender(genderService.getGender(genderId));
        doctorService.addClient(doctor);
        return "redirect:/";
    }


}