package project.thirdproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//@RequiredArgsConstructor
//@Configuration
//@EnableWebSocket
public class WebSocketHandler extends TextWebSocketHandler {
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
//    private final List<WebSocketSession> list = new ArrayList<>();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session){
//        sessions.add(session);
//        // 사용자의 ID를 세션에서 추출 (예: 세션의 Principal에서 사용자 정보를 가져와서)
//        String userId = extractUserIdFromSession(session);
//
//        // 1대1 채팅방 생성 또는 조회
//        ChatRoom chatRoom = chatService.findOrCreateRoom(userId);

        // 채팅방에 사용자 세션 추가
//        chatRoom.addParticipant(session);
//    }

//    @Override
//    protected  void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
//        String payload = message.getPayload();
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//
//        ChatRoom chatRoom = this.chatService.findRoomById(chatMessage.getRoomId());
//        chatRoom.handlerActions(session, chatMessage, chatService);
//    }
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
//        sessions.remove(session);
//    }

}
