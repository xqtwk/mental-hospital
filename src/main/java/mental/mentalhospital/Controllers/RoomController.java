package mental.mentalhospital.Controllers;

import mental.mentalhospital.Entities.Room;
import mental.mentalhospital.Services.FloorService;
import mental.mentalhospital.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.SysexMessage;
import javax.validation.Valid;
@Controller
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    FloorService floorService;
    @GetMapping("/rooms")
    public String index(Model model){
        model.addAttribute("rooms", roomService.getAllClients());
        return "rooms";
    }
    @GetMapping("/addroom")
    public String roomNew(Model model){
        model.addAttribute("floors", floorService.getAllClients());
        System.out.println(floorService.getAllClients());
        return "addroom";
    }
    @PostMapping("/addroom")
    public String addClient(@Valid @ModelAttribute Room room, BindingResult result,
                            @RequestParam("room_number") Integer room_numberown,
                            @RequestParam("room_description") String room_description,
                            @RequestParam("patients_limit") Integer patients_limit,
                            @RequestParam("floor") Integer floor_ID,
                            Model model){
        if (result.hasErrors()){
            return "/addroom";
        }
        model.addAttribute("floors", floorService.getAllClients());
        System.out.println(room.getFloor());
        room.setRoom_number(room_numberown);
        room.setRoom_description(room_description);
        room.setPatients_limit(patients_limit);
        room.setFloor(floorService.getClients(floor_ID));
        roomService.addClients(room);
        return "redirect:/rooms";
    }
    @GetMapping("/editroom")
    public String roomNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("room",roomService.getClients(id));
        model.addAttribute("floors", floorService.getAllClients());
        return "editroom";
    }
    @PostMapping("/editroom")
    public String roomUpdate(@ModelAttribute Room c){
        roomService.updateClients(c);
        return "redirect:/rooms";
    }
    @GetMapping("/deleteroom")
    public String roomDelete(Model model, @RequestParam("id") Integer id){
        roomService.deleteClients(id);
        return "redirect:/rooms";
    }
}
