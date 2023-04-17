package ysu.szx.ysuacmoj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class YsuacmojApplication {

	public static void main(String[] args) {
		SpringApplication.run(YsuacmojApplication.class, args);
	}

}
