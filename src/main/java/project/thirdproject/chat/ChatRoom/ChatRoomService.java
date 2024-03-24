package project.thirdproject.chat.ChatRoom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.thirdproject.chat.ChatRoomDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository roomRepository;

    public List<ChatRoom> findAllRooms(){
        return this.roomRepository.findAll();
    }

    public void createRoom(String name){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        this.roomRepository.save(chatRoom);
    }

    public ChatRoom findByRoomId(Long id){
        return this.roomRepository.findById(id).get();
    }
}
