package ysu.szx.ysuacmoj.Service;

import org.springframework.stereotype.Service;
import ysu.szx.ysuacmoj.Utils.FileTraversalUtils;

import java.io.File;
import java.util.ArrayList;

@Service
public class FileTraversalService {
    private FileTraversalUtils fileTraversalUtils = new FileTraversalUtils();
    public ArrayList<String> TraverseFiles(String path){
        File folder = new File(path);
        return fileTraversalUtils.TraverseFiles(folder);
    }
}
