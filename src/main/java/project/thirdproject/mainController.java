package project.thirdproject;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    @GetMapping("/test")
    public String index() {
        return "test";
    }

    @GetMapping("/")
    public String test(UserCreateForm userCreateForm){
            String a = "18";
            String b = "8";

            int maxLen = a.length() > b.length() ? a.length() : b.length();

            LevenshteinDistance ld = new LevenshteinDistance();

            double result = 0;
            double temp = ld.apply(a, b);
            result = (maxLen - temp) / maxLen;

            if(result > 0.51) {
                System.out.println("half over");
                System.out.println(result);
            } else {
                System.out.println("half not over");
                System.out.println(result);
            }

        return "product";
    }

//    @GetMapping("/chatting")
    public String test1(Model model, @RequestParam String id){
        String id2 = id;
        model.addAttribute("id",id2);
        return "ChatWindow";
    }

}
