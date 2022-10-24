package sb.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.service.UserService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(){
        return "user/signup";
    }
    //회원가입 시작

    @PostMapping("/signup")
    public String signupFin(User user){
        log.info("{}", user);
        userService.save(user);
        return "redirect:/";
    }
    //회원가입
}
