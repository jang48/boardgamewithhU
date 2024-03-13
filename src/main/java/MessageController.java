import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ServerEndpoint("/websocket")
public class MessageController {

    private static final List<Session> session = new ArrayList<>();


    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg) {
        for (int i = 0; i < session.size(); i++) {
            if (!recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    session.get(i).getBasicRemote().sendText("상대 : " + msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    session.get(i).getBasicRemote().sendText("나 : " + msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
