package ysu.szx.ysuacmoj.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ysu.szx.ysuacmoj.Mapper.CompetitionMapper;
import ysu.szx.ysuacmoj.Pojo.Competition;

@Repository
public class CompetitionDao {
    @Autowired
    private CompetitionMapper competitionMapper;

    public void Regist(Competition competition) {

    }
}
