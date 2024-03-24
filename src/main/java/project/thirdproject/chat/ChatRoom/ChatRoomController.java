package project.thirdproject.chat.ChatRoom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.thirdproject.user.SiteUser;
import project.thirdproject.user.UserCreateForm;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    @GetMapping(value = "/rooms")
    public String rooms(Principal principal, UserCreateForm userCreateForm, Model model){
        principal.getName();
        List<ChatRoom> chatRoomList = this.chatRoomService.findAllRooms();
        model.addAttribute("list",chatRoomList);
//        return "chat/rooms";
        return "test";
    }


    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(Principal principal, @RequestParam String name, Model model){
        this.chatRoomService.createRoom(name);
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public String getRoom(Principal principal, String roomId, Model model){
        ChatRoom chatRoom = this.chatRoomService.findByRoomId(Long.valueOf(roomId));
        model.addAttribute("room", chatRoom);
        return "redirect:/chat/rooms";
    }
}
