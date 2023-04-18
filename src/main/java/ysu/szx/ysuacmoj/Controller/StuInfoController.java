package ysu.szx.ysuacmoj.Controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.ScoreUpdateService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StuInfoController {
    @Autowired
    private ScoreUpdateService scoreUpdateService;

    @RequestMapping("updateScore")
    public Results UpdateScore(HttpServletRequest HttpRequest, @RequestBody Map<String, Object> request){
        String jwt = HttpRequest.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        String id = claims.get("id").toString();

        String name = request.get("name").toString(); // Give Competition Name
        Float score = (Float)request.get("score"); // Gite Competition Score

        return scoreUpdateService.UpdateScore(name, id, score);
    }
}
