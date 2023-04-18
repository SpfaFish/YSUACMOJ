package ysu.szx.ysuacmoj.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "rootPassword";
    private static Long expire = 3600000 * 24L;//24h
    public static String GetStringJwt(Map<String, Object> claims){
       String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)//签名算法
                .setClaims(claims)//自定义文件
                .setExpiration(new Date(System.currentTimeMillis() + expire)) //1h
                .compact();
       return jwt;
    }
    public static Claims ParseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)//指定密钥
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

}
