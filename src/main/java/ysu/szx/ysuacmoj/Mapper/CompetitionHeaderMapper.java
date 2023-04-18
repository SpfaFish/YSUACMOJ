package ysu.szx.ysuacmoj.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ysu.szx.ysuacmoj.Pojo.CompetitionHeader;

@Mapper
public interface CompetitionHeaderMapper {
    @Select("select id, password from competitionHeader where name = #{name}")
    public CompetitionHeader GetByName(String name);

    @Insert("insert into competition (id, name, flag) values (#{id}, #{name}, #{flag})")
    public Integer Insert(CompetitionHeader competitionHeader);
}
