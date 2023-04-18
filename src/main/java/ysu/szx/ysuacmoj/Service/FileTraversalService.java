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
    public ArrayList<String> TraverseFiles(String path) throws IOException {
        System.out.println(path);
        Resource resource = new ClassPathResource(path);
        System.out.println(resource.getFile().getPath());
        File folder = new File(resource.getFile().getPath());
        return fileTraversalUtils.TraverseFiles(folder);
    }
}
