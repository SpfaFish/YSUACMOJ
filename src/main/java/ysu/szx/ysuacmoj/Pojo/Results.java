package ysu.szx.ysuacmoj.Pojo;

import io.jsonwebtoken.impl.crypto.RsaProvider;

public class Results {
    private Integer code;
    private String msg;
    private Object data;
    public Results(){

    }
    public Results(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public Object getData(){
        return data;
    }
    public static Results Success(Object data){
        return new Results(1, "success", data);
    }
    public static Results Success(){
        return new Results(1, "success", null);
    }
    public static Results Error(Object data){
        return new Results(0, "error", data);
    }
    public static Results Error(){
        return new Results(0, "error", null);
    }
}
