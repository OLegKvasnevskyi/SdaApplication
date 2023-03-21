package net.javaguides.sms.controller;


import net.javaguides.sms.entity.ConferenceRoom;
import net.javaguides.sms.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConferenceRoomController {
    private ConferenceRoomService conferenceRoomService;

    @Autowired
    public ConferenceRoomController(ConferenceRoomService conferenceRoomService) {
        this.conferenceRoomService = conferenceRoomService;
    }


    @GetMapping("/conferencerooms")
    public String listConferenceRooms(Model model) {
        model.addAttribute("conferencerooms", conferenceRoomService.getAllConferenceRooms());
        System.out.println(model.toString());
        return "conferencerooms";
    }

    @PostMapping("/conferencerooms")
    public String saveConferenceRoom(@ModelAttribute("conferenceroom") ConferenceRoom conferenceRoom) {
        conferenceRoomService.saveConferenceRoom(conferenceRoom);
        return "redirect:/conferencerooms";
    }

    @GetMapping("/conferencerooms/new")
    public String createConferenceRoomForm(Model model) {
        ConferenceRoom conferenceRoom = new ConferenceRoom();
        model.addAttribute("conferenceroom", conferenceRoom);
        return "create_conferenceroom";
    }

    @GetMapping("/conferencerooms/edit/{id}")
    public String editConferenceRoomForm(@PathVariable Integer id, Model model) {
        model.addAttribute("conferenceroom", conferenceRoomService.getConferenceRoomById(id));
        return "edit_conferenceroom";
    }

    @PostMapping("/conferencerooms/{id}")
    public String updateConferenceRoom(@PathVariable Integer id,
                                       @ModelAttribute("conferenceroom") ConferenceRoom conferenceRoom, Model model) {
        ConferenceRoom existingConferenceRoom = conferenceRoomService.getConferenceRoomById(id);
        existingConferenceRoom.setId(id);
        existingConferenceRoom.setName(conferenceRoom.getName());
        conferenceRoomService.updateConferenceRoom(existingConferenceRoom);
        return "redirect:/conferencerooms";
    }

    @GetMapping("/conferencerooms/{id}")
    public String deleteConferenceRoom(@PathVariable Integer id) {
        conferenceRoomService.deleteConferenceRoomById(id);
        return "redirect:/conferencerooms";
    }
}
