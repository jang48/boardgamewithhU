package project.thirdproject.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm){
        return "signup_form";
    }

    @GetMapping("/login")
    public String login(UserCreateForm userCreateForm) {
        return "login_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {

        userService.create(userCreateForm.getUsername(),
                userCreateForm.getEmail(), userCreateForm.getPassword1(), userCreateForm.getPhone(),"");

        return "redirect:/";
    }
    @GetMapping("/mypage")
    public String mypage(UserCreateForm userCreateForm, Principal principal, Model model) {
        String name = principal.getName();
        SiteUser user = this.userService.findUser(name);
        model.addAttribute("user",user);
        return "/user/mypage_form";
    }
}
