package ysu.szx.ysuacmoj.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionHeader {
    String id;
    String name;
    Boolean flag;//check if it is rated
}
