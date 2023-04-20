package ysu.szx.ysuacmoj;

import java.util.Set;

//@Configuration
public class MapConfiguration{
    private static Set<String> acceptUrlSet;
    CorsConfiguration(){
        acceptUrlSet.add("http://10.136.132.34:9000/regist");
        acceptUrlSet.add("http://10.136.132.34:9000/login");
        acceptUrlSet.add("http://localhost/regist");
        acceptUrlSet.add("http://localhost:9000/login");
    }
}
