package ysu.szx.ysuacmoj;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ysu.szx.ysuacmoj.Controller.LoginController;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Pojo.Results;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class YsuacmojApplicationTests {
	@Autowired
	private StuDao stuDao;

	@Test
	void contextLoads() {
		Stu stu = stuDao.GetByPassword("123", "123");
	}

	@Test
	public void TtestJwt(){
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1);
		claims.put("name", "test");
		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, "password")//签名算法
				.setClaims(claims)//自定义文件
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //1h
				.compact();
		System.out.println(jwt);
	}
	@Test
	public void testParseJwt(){
		Claims claims = Jwts.parser()
				.setSigningKey("password")//指定密钥
				.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJleHAiOjE2ODE3OTY2MjV9.rgLu0n7upb2Vb0SmHaMEgnAE-7H5OXnZCN2alG_rG1U")
				.getBody();
		System.out.println(claims);
	}
}
