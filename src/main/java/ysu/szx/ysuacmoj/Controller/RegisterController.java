package ysu.szx.ysuacmoj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.RegisterService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/regist")
    public Results Regist(@RequestBody Map<String, Object> request){
        String id = (String)request.get("id");
        String name = (String)request.get("name");
        String nickName = (String)request.get("nickName");
        String password = (String)request.get("password");
        Stu stu = new Stu(id, name, nickName, password, (float)1200);
        return registerService.Insert(stu);
    }
}
