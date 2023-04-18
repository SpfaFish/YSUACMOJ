package ysu.szx.ysuacmoj.Controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Mapper.CompetitionHeaderMapper;
import ysu.szx.ysuacmoj.Mapper.CompetitionMapper;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.CompetitionListService;
import ysu.szx.ysuacmoj.Service.CompetitionRegistService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.util.ArrayList;

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
    @RequestMapping("/competitionRegist")
    public Results RegistCompetition(HttpServletRequest request, String compName){
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        String id = claims.get("id").toString();
        if(id != "root") return Results.Error("permision denied");//校验管理员
        return competitionRegistService.RegistCompetition(compName);
    }
}
