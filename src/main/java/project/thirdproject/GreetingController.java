package project.thirdproject;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/websocket")
public class GreetingController extends Socket {
//    @MessageMapping("/greeting")  //requestMapping과 비슷 ( app/hello다 websocketbrokerconfig에서 app을 작성했잖아
//    @SendTo("/queue/greeting") // topic greeting이라는 경로로 다시 보낸다
//    public String info(String message){
//        return "";
//    }
//
//
//    private static final List<Session> session = new ArrayList<Session>();
//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }
//
//    @OnOpen
//    public void open(Session newUser) {
//        System.out.println("connected");
//        session.add(newUser);
//        System.out.println("현재 접속중인 유저 수 : " + session.size());
//    }
//
//    @OnMessage
//    public void getMsg(Session recieveSession, String msg) {
//        for (int i = 0; i < session.size(); i++) {
//            if (! recieveSession.getId().equals(session.get(i).getId())) {
//                try {
//                    session.get(i).getBasicRemote().sendText("유저" + (Integer.parseInt(session.get(i).getId()) + 1) + " : " + msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                try {
//                    session.get(i).getBasicRemote().sendText("나 : " + msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Scheduled(cron = "* * * * * *")
//    private void isSessionClosed() {
//        if (session.size() != 0) {
//            try {
//                System.out.println("! = " + session.size());
//                for (int i = 0; i < session.size(); i++) {
//                    if (! session.get(i).isOpen()) {
//                        session.remove(i);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
