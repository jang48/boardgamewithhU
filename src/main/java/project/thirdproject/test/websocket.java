package project.thirdproject.test;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/ChatingServer")
public class websocket {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

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
