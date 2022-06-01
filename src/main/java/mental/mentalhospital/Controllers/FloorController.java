package mental.mentalhospital.Controllers;

import mental.mentalhospital.Entities.Floor;
import mental.mentalhospital.Services.FloorService;
import org.springframework.stereotype.Controller;
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
public class FloorController {
    @Autowired
    FloorService floorService;
    @GetMapping("/floors")
    public String index(Model model){
        model.addAttribute("floors", floorService.getAllClients());
        return "floors";
    }
    @GetMapping("/addfloor")
    public String floorNew(Model model){
        return "addfloor";
    }
    @PostMapping("/addfloor")
    public String addClient(@Valid @ModelAttribute Floor floor, BindingResult result, @RequestParam("number") Integer number,
                            @RequestParam("room_number") Integer room_number,
                            Model model){
        if (result.hasErrors()){
            return "/addfloor";
        }
        floor.setNumber(number);
        floor.setRoom_number(room_number);
        //Floor c = new Floor(name,surname,email,phone);
        floorService.addClients(floor);
        return "redirect:/floors";
    }
    @GetMapping("/editfloor")
    public String floorNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("floor",floorService.getClients(id));
        return "editfloor";
    }
    @PostMapping("/editfloor")
    public String floorUpdate(@ModelAttribute Floor c){
        floorService.updateClients(c);
        return "redirect:/floors";
    }
    @GetMapping("/deletefloor")
    public String floorDelete(Model model, @RequestParam("id") Integer id){
        floorService.deleteClients(id);
        return "redirect:/floors";
    }
}
