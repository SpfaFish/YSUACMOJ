package ysu.szx.ysuacmoj.Controller;

import ch.qos.logback.core.pattern.FormatInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ysu.szx.ysuacmoj.Dao.StuDao;
import ysu.szx.ysuacmoj.Mapper.StuMapper;
import ysu.szx.ysuacmoj.Peo.Stu;

import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private StuDao stuDao;
    @PostMapping("/upload")
    public String upload(String id, String password, MultipartFile file) throws Exception {
        Stu Stu = stuDao.GetByPassword(id, password);
        if(Stu == null) return "Fail";
        String originalFilename = file.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extraName = originalFilename.substring(index);
//        String preName = originalFilename.substring(0, index);
//        String newFileName = UUID.randomUUID().toString() + extraName;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(System.currentTimeMillis()).toString();
        file.transferTo(new File("UploadFile\\" + id + "\\" + nowTime + originalFilename));
        log.info("文件名:{}", nowTime + originalFilename);
        return "Success";
    }
}
