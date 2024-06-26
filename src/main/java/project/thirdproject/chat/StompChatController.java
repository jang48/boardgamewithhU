package project.thirdproject.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import project.thirdproject.chat.ChatMessage.ChatMessage;
import project.thirdproject.chat.ChatMessage.ChatMessageService;
import project.thirdproject.chat.ChatMessageDTO;
import project.thirdproject.chat.ChatRoom.ChatRoom;
import project.thirdproject.chat.ChatRoom.ChatRoomService;


@Controller
@RequiredArgsConstructor
public class StompChatController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private final ChatMessageService messageService;
    private final ChatRoomService chatRoomService;

//    //Client가 SEND할 수 있는 경로
//    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
//    //"/pub/chat/enter"
//    @MessageMapping(value = "/chat/enter")
//    public void enter(ChatMessageDTO message){
//        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
//
//        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//    }
//
//    @MessageMapping(value = "/chat/message")
//    public void message(ChatMessageDTO message){
//        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//    }


    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"
    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessage message){
        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessage message){
        ChatRoom chatRoom = this.chatRoomService.findByRoomId(message.getRoomId());
        this.messageService.saveChatMessage(message,chatRoom);
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

}
