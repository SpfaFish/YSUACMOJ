package ysu.szx.ysuacmoj.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.LoginService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public Results Login(String id, String password){
//        System.out.println(id);
//        System.out.println(password);
        if(loginService.CheckStu(id, password)){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", id);
            String jwt = JwtUtils.GetStringJwt(claims);
            return Results.Success(jwt);
        }else return Results.Error("用户名或密码错误");
    }
}
