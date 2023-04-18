package ysu.szx.ysuacmoj.Controller;

import ch.qos.logback.core.pattern.FormatInfo;
import io.jsonwebtoken.Claims;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Mapper.StuMapper;
import ysu.szx.ysuacmoj.Peo.Stu;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private StuDao stuDao;
    @RequestMapping("/upload")
    public Results upload(HttpServletRequest request, MultipartFile file) throws Exception {
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        String id = claims.get("id").toString();
//        System.out.println(id);
        String originalFilename = file.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extraName = originalFilename.substring(index);
//        String preName = originalFilename.substring(0, index);
//        String newFileName = UUID.randomUUID().toString() + extraName;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String nowTime = df.format(System.currentTimeMillis()).toString();
        String folderPath = "E:\\YSUACMOJ\\YSUACMOJ\\src\\main\\resources\\UploadFile\\" + id;
//        String folderPath = "UploadFile\\" + id;
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        file.transferTo(new File(folderPath + "\\" + nowTime + "-" + nowTime + originalFilename));
//        file.transferTo(new File("UploadFile\\" + "\\" + nowTime + originalFilename));
//        file.transferTo(tmpFile);
        log.info("文件名:{}", nowTime + originalFilename);
        return Results.Success();
    }
}
