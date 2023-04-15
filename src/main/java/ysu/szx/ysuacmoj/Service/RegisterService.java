package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Peo.Stu;

@Service
public class RegisterService {
    @Autowired
    StuDao stuDao;

    public String Insert(Stu stu){
        if(stuDao.Insert(stu)) return "Success";
        return "Fail";
    }
}
