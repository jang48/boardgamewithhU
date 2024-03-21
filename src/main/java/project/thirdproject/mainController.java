package project.thirdproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.thirdproject.user.UserCreateForm;

import java.security.Principal;

@Controller
public class mainController {
    @GetMapping("/test")
    public String index() {
        return "test";
    }

    @GetMapping("/")
    public String main2(UserCreateForm userCreateForm, Principal principal, Model model){
        if(principal == null){
            model.addAttribute("principal", "");
        } else {
            model.addAttribute("principal", principal.getName());
        }
        return "top_layout";
    }

//    @GetMapping("/chatting")
    public String test1(Model model, @RequestParam String id){
        String id2 = id;
        model.addAttribute("id",id2);
        return "ChatWindow";
    }

}
