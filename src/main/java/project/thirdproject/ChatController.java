package project.thirdproject;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;
    @RequestMapping("/chat/add")
    public String showadd(){
        return "chat/add";
    }

    @RequestMapping("/chat/doAdd")
    @ResponseBody
    public String doAdd(@RequestParam Map<String, Object> param, HttpServletRequest request){

//        String idStr = CookieUtil.getAttribute(request,"id");
//        if(memberId == null){
//            return "<script> alert('로그인 후 이용해주세요.'); history.back();</script>";
//        }
        param.put("memberId","1");
        Map<String, Object> rs = chatService.doAdd(param);
        int id = (int)rs.get("id");
        return id + "번 채팅방이 생성되었습니다.";
    }
}
