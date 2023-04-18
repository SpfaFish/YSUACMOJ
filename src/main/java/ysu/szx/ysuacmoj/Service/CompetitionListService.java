package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ysu.szx.ysuacmoj.Dao.CompetitionHeaderDao;
import ysu.szx.ysuacmoj.Mapper.CompetitionHeaderMapper;
import ysu.szx.ysuacmoj.Pojo.Competition;
import ysu.szx.ysuacmoj.Pojo.CompetitionHeader;

import java.util.ArrayList;

@Service
public class CompetitionListService {
    @Autowired
    private CompetitionHeaderDao competitionHeaderDao;
    @RequestMapping("/competitionList")
    public ArrayList<CompetitionHeader> GetCompetitionList(){
        return competitionHeaderDao.GetAllCompetition();
    }

}
