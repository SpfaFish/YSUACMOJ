package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Dao.CompetitionHeaderDao;
import ysu.szx.ysuacmoj.Pojo.Results;

@Service
public class CompetitionService {
    @Autowired
    CompetitionHeaderDao competitionHeaderDao;
    public Results FindConmpetition(String name){
        return competitionHeaderDao.Find(name);
    }
}
