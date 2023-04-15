package ysu.szx.ysuacmoj.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ysu.szx.ysuacmoj.Peo.Stu;

@Mapper
public interface StuMapper {
    @Select("select id, password from stuinfo where id = #{id} && password = #{password}")
    public Stu GetByPassword(String id, String password);

    @Select("select id from stuinfo where id = #{id}")
    public Stu GetById(String id);

    @Insert("insert into stuinfo (id, name, nickName, password, rating) values (#{id}, #{name}, #{nickName}, #{password}, #{rating})")
    public Integer Insert(Stu stu);
}
