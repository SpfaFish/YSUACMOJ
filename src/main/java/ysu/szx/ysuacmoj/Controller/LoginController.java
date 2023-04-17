package ysu.szx.ysuacmoj.Controller;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.LoginService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public Results Login(@RequestBody Map<String, Object> request){
        String id = (String)request.get("id");
        String password = (String)request.get("password");
        System.out.println(id);
        System.out.println(password);
        if(loginService.CheckStu(id, password)){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", id);
            String jwt = JwtUtils.GetStringJwt(claims);
            return Results.Success(jwt);
        }else return Results.Error("用户名或密码错误");
    }
}
