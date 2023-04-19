package ysu.szx.ysuacmoj.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ysu.szx.ysuacmoj.Pojo.Competition;
import ysu.szx.ysuacmoj.Pojo.CompetitionHeader;

import java.util.ArrayList;

@Mapper
public interface CompetitionHeaderMapper {
    @Select("select name, flag from competitionHeader where name = #{name}")
    public CompetitionHeader GetByName(String name);

    @Select("select * from competitionHeader")
    public ArrayList<CompetitionHeader> GetAllCompetition();

    @Insert("insert into competitionHeader (name, flag) values (#{name}, #{flag})")
    public Integer Insert(CompetitionHeader competitionHeader);
}
