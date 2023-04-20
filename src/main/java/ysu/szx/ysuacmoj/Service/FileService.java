package ysu.szx.ysuacmoj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Utils.FileUtils;

import java.io.File;

@Service
public class FileService {
    @Autowired
    private FileUtils fileUtils;
    public Results DeleteFile(String path){
        File file = new File(path);
        if(!file.exists()){
            return Results.Error("No such file");
        }
        if(fileUtils.DeleteFile(file)){
            return Results.Success();
        }else return Results.Error("Delete failed");
    }
}
