package project.thirdproject.test;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//@ServerEndpoint("/ChatingServer")
@Controller
public class websocket {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @GetMapping("/chatting")
    public String test(Model model){
        model.addAttribute("chatList","hello");
        return "test";
    }

    @MessageMapping("/topic/chat") // 클라이언트로부터 메시지 수신 시 처리할 엔드포인트
    @SendTo("/topic/chat")
    public String handleChatMessage(String message){
        return "Received message : " + message;
    }
    @OnOpen
    public void onOpen(Session session){
        clients.add(session);
        System.out.println("웹소켓 연결 : " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException{
        System.out.println("메시지 전송 : " + session.getId() + message);
        synchronized (clients){
            for(Session client : clients){
                if(!client.equals(session)){
                    client.getBasicRemote().sendText(message);
                }
            }

        }
    }

    @OnClose
    public void onClose(Session session){
        clients.remove(session);
        System.out.println("웹소켓 종료 : " + session.getId());
    }

    @OnError
    public void onError(Throwable e){
        System.out.println("에러발생");
        e.printStackTrace();
    }
}
