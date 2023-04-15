package ysu.szx.ysuacmoj.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ysu.szx.ysuacmoj.Mapper.StuMapper;
import ysu.szx.ysuacmoj.Peo.Stu;

@Repository
public class StuDao {
    @Autowired
    private StuMapper stuMapper;
    public Stu GetByPassword(String id, String password){
        return stuMapper.GetByPassword(id, password);
    }
    public boolean Insert(Stu stu){
        if(stuMapper.GetById(stu.getId()) != null) return false;
        return stuMapper.Insert(stu) == 1;
    }
}
