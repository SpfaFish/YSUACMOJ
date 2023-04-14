package ysu.szx.ysuacmoj.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ysu.szx.ysuacmoj.Peo.Stu;

@Mapper
@Repository
public interface StuMapper {
    @Select("select * from emp where id = #{id}, password = #{password}")
    public Stu GetByPassword(String id, String password);
}
