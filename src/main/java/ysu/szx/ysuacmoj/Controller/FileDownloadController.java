package ysu.szx.ysuacmoj.Controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Service.FileDownloadService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.io.File;
import java.io.IOException;

@RestController
public class FileDownloadController {
    @Autowired
    private FileDownloadService fileDownloadService;
    @RequestMapping("/download")
    public ResponseEntity<Resource> Download(String fileName, HttpServletRequest request) throws IOException {
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        String id = claims.get("id").toString();
        String filePath = "E:\\YSUACMOJ\\YSUACMOJ\\src\\main\\resources\\UploadFile\\" + id + "\\" + fileName;
//        File file = fileDownloadService.GetByPath(filePath);
//        System.out.println(filePath);
//        MultipartFile returnFile = (MultipartFile) file;
//        if(file == null) return Results.Error("Can Not Find File");
//        else return Results.Success(((MultipartFile) file).getBytes());
        String contentDisposition = ContentDisposition
                .builder("attachment")
                .filename(filePath)
                .build().toString();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .contentType(MediaType.IMAGE_JPEG)
                .body(new FileSystemResource(filePath));
    }
}
