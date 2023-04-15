package ysu.szx.ysuacmoj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Peo.Stu;

@SpringBootTest
class YsuacmojApplicationTests {
	@Autowired
	private StuDao stuDao;
	@Test
	void contextLoads() {
		Stu stu = stuDao.GetByPassword("123", "123");
	}

}
