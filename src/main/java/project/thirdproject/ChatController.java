package project.thirdproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    @GetMapping("/chat")
    public String chatGET(){

        log.info("@ChatController, chat GET()");

        return "chat";
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

    // @ServerEndpoint("/chat")
    //  public class ChatEndpoint {}

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
