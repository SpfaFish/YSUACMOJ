package ysu.szx.ysuacmoj.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileDownloadService {
    public File GetByPath(String filePath){
        File file = new File(filePath);
        if(file.exists()) return file;
        else return null;
    }
}
