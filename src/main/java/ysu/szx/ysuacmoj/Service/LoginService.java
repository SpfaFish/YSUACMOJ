package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Peo.Stu;

@Service
public class LoginService {
    @Autowired
    private StuDao stuDao;
    public boolean CheckStu(String id, String password){
        Stu stu = stuDao.GetByPassword(id, password);
        if(stu != null) return true;
        else return false;
    }
}
