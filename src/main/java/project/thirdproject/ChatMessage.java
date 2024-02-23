package project.thirdproject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType{
        ENTER, TALK
        // 사용자, 채팅방에 들어오는 사람
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
