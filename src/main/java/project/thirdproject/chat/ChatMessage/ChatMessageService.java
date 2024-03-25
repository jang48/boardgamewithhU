package project.thirdproject.chat.ChatMessage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.thirdproject.chat.ChatRoom.ChatRoom;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public void saveChatMessage(ChatMessage message, ChatRoom chatRoom){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage(message.getMessage());
        chatMessage.setWriter(message.getWriter());
        chatMessage.setRoomId(message.roomId);
        chatMessage.setChatRoom(chatRoom);
        chatMessage.setTime(LocalDateTime.now());
        this.chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessageByRoomId(Long RoomId){
        List<ChatMessage> messageList = this.chatMessageRepository.findByroomId(RoomId);
        return messageList;
    }
}
