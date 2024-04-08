package project.thirdproject.chat.ChatRoom;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.thirdproject.chat.ChatMessage.ChatMessage;
import project.thirdproject.chat.ChatMessage.ChatMessageService;
import project.thirdproject.user.SiteUser;
import project.thirdproject.user.UserCreateForm;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    private final ChatMessageService messageService;

    @GetMapping(value = "/rooms")
    public String rooms(Principal principal, UserCreateForm userCreateForm, Model model) {
        principal.getName();
        List<ChatRoom> chatRoomList = this.chatRoomService.findAllRooms();
        model.addAttribute("list", chatRoomList);

        ChatRoom room = new ChatRoom();
        room.setName("test");
        model.addAttribute("room", room);
//        return "chat/rooms";
        return "test";
    }

    @GetMapping(value = "/rooms/detail/{roomId}")
    public String rooms(Principal principal, @PathVariable("roomId") String roomId, UserCreateForm userCreateForm, Model model) {
        principal.getName();
        List<ChatRoom> chatRoomList = this.chatRoomService.findAllRooms();
        model.addAttribute("list", chatRoomList);

        ChatRoom chatRoom = this.chatRoomService.findByRoomId(Long.valueOf(roomId));
        model.addAttribute("room", chatRoom);

        return "test";
    }

//    @GetMapping(value = "/message")
//    public Object messageList(Principal principal, @RequestParam String roomId) {
//        List<ChatMessage> messageList = this.messageService.findChatMessageByRoomId(Long.valueOf(roomId));
//        Map<String, Object> map = new HashMap<>();
////        for(ChatMessage chatMessage : messageList){
////            map.put("message", chatMessage.getMessage());
////            map.put("time", chatMessage.getTime());
////            map.put("writer", chatMessage.getWriter());
////        }
////        JSONObject Data = new JSONObject(map);
//        System.out.println(Data);
//        return Data;
//    }

    @GetMapping("/message")
    @ResponseBody
    public List<Map<String, Object>> messageList(@RequestParam("roomId") Long roomId) {
        List<ChatMessage> messageList = this.messageService.findChatMessageByRoomId(roomId);

        List<Map<String, Object>> resultList = new ArrayList<>();
        for (ChatMessage chatMessage : messageList) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", chatMessage.getMessage());
            map.put("time", chatMessage.getTime());
            map.put("writer", chatMessage.getWriter());
            resultList.add(map);
        }
        return resultList;
    }



    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(Principal principal, @RequestParam String name, Model model) {
        this.chatRoomService.createRoom(name);
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public String getRoom(String roomId) {
        return "redirect:/chat/rooms/detail/" + roomId;
    }
}
