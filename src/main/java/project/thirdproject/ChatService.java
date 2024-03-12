package project.thirdproject;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;
//    public Map<String, Object> doAdd(Map<String, Object> param);
//
//    public List<Chatroom> getList();

    public void doAdd(String memberId, Integer roomId, String passwd){
        Chatroom chatroom1 = new Chatroom();
        chatroom1.setRoomId(Long.valueOf(roomId));
        chatroom1.setPasswd(passwd);
        chatroom1.setTitle("Test입니다");
        chatroom1.setRegDate(LocalDateTime.now());
        this.chatRepository.save(chatroom1);
    }
    public List<Chatroom> getList(){
        return this.chatRepository.findAll();
    }

    public Chatroom findById(Long id) {
        return this.chatRepository.findByid(id);
    }

    public void addMessage() {
    }
}
