package ysu.szx.ysuacmoj.Controller;

import ch.qos.logback.core.pattern.FormatInfo;
import io.jsonwebtoken.Claims;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Mapper.StuMapper;
import ysu.szx.ysuacmoj.Peo.Stu;
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
    public String upload(MultipartFile file,String orgId,HttpServletRequest request) throws Exception {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        String jwt = req.getHeader("token");
//        Claims claims = JwtUtils.ParseJwt(jwt);
//        String id = claims.get("id").toString();
        String originalFilename = file.getName();
//        int index = originalFilename.lastIndexOf(".");
//        String extraName = originalFilename.substring(index);
//        String preName = originalFilename.substring(0, index);
//        String newFileName = UUID.randomUUID().toString() + extraName;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(System.currentTimeMillis()).toString();
//        file.transferTo(new File("UploadFile\\" + id + "\\" + nowTime + originalFilename));
        file.transferTo(new File("UploadFile\\" + "\\" + nowTime + originalFilename));
        log.info("文件名:{}", nowTime + originalFilename);
        return "Success";
    }
}
