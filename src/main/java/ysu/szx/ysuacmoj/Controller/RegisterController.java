package ysu.szx.ysuacmoj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Service.RegisterService;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public String Register(String id, String name, String nickName, String password){
        Stu stu = new Stu(id, name, nickName, password, (float)1200);
        return registerService.Insert(stu);
    }
}
