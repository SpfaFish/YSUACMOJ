package ysu.szx.ysuacmoj.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competition {
    String id;
    String name;
    String stuId;
    Float score;
}
