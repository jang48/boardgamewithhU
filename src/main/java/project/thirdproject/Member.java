package project.thirdproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String memberId;

    String memberPw;

    String memberName;

    @OneToMany(mappedBy = "member")
    List<Chatroom> chatroomList;

}
