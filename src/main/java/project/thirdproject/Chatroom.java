package project.thirdproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDateTime regDate;

    String title;

    String passwd;

    Long roomId;

    @ManyToOne
    Member member;

//    memberId
}
