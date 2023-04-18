package ysu.szx.ysuacmoj.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ysu.szx.ysuacmoj.Mapper.CompetitionHeaderMapper;

@Repository
public class CompetitionHeaderDao {
    @Autowired
    private CompetitionHeaderMapper competitionHeaderMapper;


}
