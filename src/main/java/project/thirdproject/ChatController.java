package project.thirdproject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping("/chat/add")
    public String showAdd(){
        return "chat/add";
    }

//    @RequestMapping("/chat/doAddMessage")
//    public Map doAddMessage(){
//        // jSon 형태로 return하려면 Map으로 return 해야해
//        chatService.addMessage();
//    }


    @RequestMapping("/chat/list")
    public String showList(Model model){
        List<Chatroom> list = chatService.getList();
        model.addAttribute("chatroomList", list);
        return "chat/list";
    }


    @RequestMapping("/chat/room")
    public String showchatRoom(@RequestParam("id") Long id,Model model){
        Chatroom chatroom = chatService.findById(id);
        model.addAttribute("chatroom", chatroom);
        return "chat/room";
    }

    @RequestMapping("/chat/doAdd")
    @ResponseBody
    public String doAdd(@RequestParam String title, @RequestParam String passwd) {

        String memberId = "1";

        Random random = new Random();
        int id =  random.nextInt(1000000);

        chatService.doAdd(memberId,id,passwd);


        String msg = id + "번 채팅방이 생성되었습니다.";
        String rsStr = "";

        rsStr += "<script>";
        rsStr += "alert('"+msg+"');";
        rsStr += "location.replace('./list');";
        //rsStr += "location.href('')";
        rsStr += "</script>";

        return rsStr;

        }

//    @RequestMapping("/chat/doAdd")
//    @ResponseBody
//    public String doAdd(@RequestParam Map<String, Object> param, HttpServletRequest request){
//
////        String idStr = CookieUtil.getAttribute(request,"id");
////        if(memberId == null){
////            return "<script> alert('로그인 후 이용해주세요.'); history.back();</script>";
////        }
////        param.put("memberId","1");
////        Map<String, Object> rs = chatService.doAdd(param);
////        int id = (int)rs.get("id");
////        return id + "번 채팅방이 생성되었습니다.";
////
////        param.put("memberId", "1");
////        Map<String, Object> rs = chatService.doAdd(param);
////
////        Object id = rs.get("id");
////        System.out.println(rs);
//
//        String memberId = "1";
//
//        Random random = new Random();
//        int id =  random.nextInt(1000000);
//
//
//
//        chatService.doAdd(memberId,id,);
//
//        String msg = id + "번 채팅방이 생성되었습니다.";
//        String rsStr = "";
//
//        rsStr += "<script>";
//        rsStr += "alert('"+msg+"');";
//        rsStr += "location.replace('./list');";
//        //rsStr += "location.href('')";
//        rsStr += "</script>";
//
//        return rsStr;
//    }

    @ServerEndpoint("/chat")
    public class ChatEndpoint {}

//    @OnOpen
//    public void onConnect(Session session, EndpointConfig config) {
//        this.hSession = (HttpSession)config.getUserProperties().get("hSession");
//        clients.add(session);
//        System.out.println(hSession.getAttribute("loginID"));
//    }
//
//    @OnMessage
//    public void onMessage(String message) {
//        synchronized (clients) {
//            for(Session client : clients) {
//                try {
//                    client.getBasicRemote().sendText(message);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
