package project.thirdproject.chat.ChatMessage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.thirdproject.chat.ChatRoom.ChatRoom;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long roomId;

    private String writer;

    @Column(columnDefinition = "text")
    private String message;

    private LocalDateTime time;

    @ManyToOne
    private ChatRoom chatRoom;
}
