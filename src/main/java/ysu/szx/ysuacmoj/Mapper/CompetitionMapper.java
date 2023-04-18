package ysu.szx.ysuacmoj.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Pojo.Competition;

@Mapper
public interface CompetitionMapper {
    @Select("select id, password from competition where id = #{id}")
    public Competition GetById(String id);

    @Select("select id, password from competition where name = #{name}")
    public Competition GetByName(String name);

    @Insert("insert into competition (id, name, stuId, score) values (#{id}, #{name}, #{stuId}, #{score})")
    public Integer Insert(Competition competition);
}
