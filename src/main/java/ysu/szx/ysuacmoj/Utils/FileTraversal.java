package ysu.szx.ysuacmoj.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class FileTraversal {
    public static ArrayList<String> TraverseFiles(File folder){
        ArrayList<String> list = new ArrayList<>();
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                list.add(files.toString());
            }
        }
        return list;
    }
}
