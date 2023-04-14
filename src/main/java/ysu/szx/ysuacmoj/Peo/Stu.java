package ysu.szx.ysuacmoj.Peo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stu {
    String id;
    String name;
    String nickName;
    String password;
    Float rating;
}
