package project.thirdproject.chat.ChatMessage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.thirdproject.chat.ChatRoom.ChatRoom;

@Entity
@Getter
@Setter
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long RoomId;

    private String sender;

    private String writer;

    @Column(columnDefinition = "text")
    private String message;

    @ManyToOne
    private ChatRoom chatRoom;
}
