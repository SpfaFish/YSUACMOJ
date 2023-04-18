package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Dao.CompetitionDao;
import ysu.szx.ysuacmoj.Dao.CompetitionHeaderDao;
import ysu.szx.ysuacmoj.Pojo.Competition;
import ysu.szx.ysuacmoj.Pojo.CompetitionHeader;
import ysu.szx.ysuacmoj.Pojo.Results;

@Service
public class CompetitionRegistService {
    @Autowired
    private CompetitionHeaderDao competitionHeaderDao;
    public Results RegistCompetition(String compName){
        return competitionHeaderDao.Regist(new CompetitionHeader(compName, 0));
    }
}
