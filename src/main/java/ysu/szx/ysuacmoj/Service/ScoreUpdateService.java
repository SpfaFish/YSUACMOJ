package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Dao.CompetitionDao;
import ysu.szx.ysuacmoj.Pojo.Competition;
import ysu.szx.ysuacmoj.Pojo.Results;

@Service
public class ScoreUpdateService {
    @Autowired
    private CompetitionDao competitionDao;
    public Results UpdateScore(String name, String id, Float score){
        return competitionDao.UpdateScore(new Competition(name, id, score));
    }
}
