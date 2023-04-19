package ysu.szx.ysuacmoj.Controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.CompetitionListService;
import ysu.szx.ysuacmoj.Service.CompetitionRegistService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CompetitionController {
    @Autowired
    private CompetitionListService competitionListService;
    @Autowired
    private CompetitionRegistService competitionRegistService;
    @RequestMapping("/competitionList")
    public Results GetCompetitionList(){
        return Results.Success(competitionListService.GetCompetitionList());
    }
    @PostMapping("/competitionRegister")
    public Results RegisterCompetition(HttpServletRequest request, @RequestBody Map<String, Object> map){
        String compName = map.get("compName").toString();
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        String id = claims.get("id").toString();
        System.out.println(compName);
        if(id.equals("root")) return competitionRegistService.RegistCompetition(compName);
        return Results.Error("permission denied");//校验管理员
    }
}
