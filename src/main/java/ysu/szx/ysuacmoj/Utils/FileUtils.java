package ysu.szx.ysuacmoj.Utils;

import org.springframework.stereotype.Component;
import ysu.szx.ysuacmoj.Pojo.Results;

import java.io.File;
import java.util.ArrayList;

@Component
public class FileUtils {
    public static ArrayList<String> TraverseFiles(File folder){
        ArrayList<String> list = new ArrayList<>();
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                list.add(file.getName());
            }
        }
        return list;
    }
    public static boolean DeleteFile(File file){
        return file.delete();
    }
}
