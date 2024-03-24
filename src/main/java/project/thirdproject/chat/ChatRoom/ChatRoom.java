package project.thirdproject.chat.ChatRoom;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.thirdproject.chat.ChatMessage.ChatMessage;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> chatMessage;
}
