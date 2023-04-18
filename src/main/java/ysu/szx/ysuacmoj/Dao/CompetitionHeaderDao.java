package ysu.szx.ysuacmoj.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ysu.szx.ysuacmoj.Mapper.CompetitionHeaderMapper;
import ysu.szx.ysuacmoj.Pojo.Competition;
import ysu.szx.ysuacmoj.Pojo.CompetitionHeader;
import ysu.szx.ysuacmoj.Pojo.Results;

import java.util.ArrayList;

@Repository
public class CompetitionHeaderDao {
    @Autowired
    private CompetitionHeaderMapper competitionHeaderMapper;

    public ArrayList<CompetitionHeader> GetAllCompetition() {
        return competitionHeaderMapper.GetAllCompetition();
    }

    public Results Regist(CompetitionHeader competitionHeader) {
        CompetitionHeader tmp = competitionHeaderMapper.GetByName(competitionHeader.getName());
        if(tmp != null) return Results.Error("name exited");
        if(competitionHeaderMapper.Insert(competitionHeader) == 1) return Results.Success();
        else return Results.Error("Insert failed");
    }
}
