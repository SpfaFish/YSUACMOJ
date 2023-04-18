package ysu.szx.ysuacmoj.Service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Utils.FileTraversalUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class FileTraversalService {
    private FileTraversalUtils fileTraversalUtils = new FileTraversalUtils();
    public ArrayList<String> TraverseFiles(String id) throws IOException {
        String folderPath = "E:\\YSUACMOJ\\YSUACMOJ\\src\\main\\resources\\UploadFile\\" + id;
//        String folderPath = "UploadFile\\" + id;
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
//        System.out.println(path);
        return fileTraversalUtils.TraverseFiles(folder);
    }
}
