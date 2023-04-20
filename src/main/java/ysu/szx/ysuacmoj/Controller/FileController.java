package ysu.szx.ysuacmoj.Controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.FileService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("fileDeleter")
    public Results DeleteFile(HttpServletRequest request, String name){
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        String id = claims.get("id").toString();
        String filePath = "E:\\YSUACMOJ\\YSUACMOJ\\src\\main\\resources\\UploadFile\\" + id + "\\" + name;
        return fileService.DeleteFile(filePath);
    }
}
