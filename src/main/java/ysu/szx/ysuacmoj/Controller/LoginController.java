package ysu.szx.ysuacmoj.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public String Login(String id, String password){
        if(loginService.CheckStu(id, password)) return "Success";
        else return "Fail";
    }
}
