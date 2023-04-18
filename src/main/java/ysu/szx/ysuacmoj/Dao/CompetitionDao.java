package ysu.szx.ysuacmoj.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ysu.szx.ysuacmoj.Mapper.CompetitionMapper;
import ysu.szx.ysuacmoj.Pojo.Competition;
import ysu.szx.ysuacmoj.Pojo.Results;

@Repository
public class CompetitionDao {
    @Autowired
    private CompetitionMapper competitionMapper;

    public Results UpdateScore(Competition competition) {
        if(competitionMapper.Insert(competition) == 1) return Results.Success();
        else return Results.Error("Score has been updated");
    }
}
