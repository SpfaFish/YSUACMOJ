package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class FileTraversalService {
    @Autowired
    private FileUtils fileUtils;
    public ArrayList<String> TraverseFiles(String id) throws IOException {
        String folderPath = "E:\\YSUACMOJ\\YSUACMOJ\\src\\main\\resources\\UploadFile\\" + id;
//        String folderPath = "UploadFile\\" + id;
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
//        System.out.println(path);
        return fileUtils.TraverseFiles(folder);
    }
}
