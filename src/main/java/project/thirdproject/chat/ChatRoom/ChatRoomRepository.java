package project.thirdproject.chat.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import project.thirdproject.chat.ChatRoom.ChatRoom;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findAll();

    Optional<ChatRoom> findById(Long id);
}
