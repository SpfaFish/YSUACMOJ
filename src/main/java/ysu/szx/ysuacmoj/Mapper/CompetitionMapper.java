package ysu.szx.ysuacmoj.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Pojo.Competition;

import java.util.ArrayList;

@Mapper
public interface CompetitionMapper {
    @Select("select id, password from competition where id = #{id}")
    public Competition GetById(String id);

    @Select("select (name) from competition where name = #{name}")
    public Competition GetByName(String name);

    @Select("select * from competition")
    public ArrayList<Competition> GetAllCompetition();

    @Insert("insert into competition (name, stuId, score) values (#{name}, #{stuId}, #{score})")
    public Integer Insert(Competition competition);


}
