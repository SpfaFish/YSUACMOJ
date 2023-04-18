package ysu.szx.ysuacmoj.Controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.szx.ysuacmoj.Service.FileTraversalService;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.util.ArrayList;

@RestController
public class FileLoadController {
    @Autowired
    private FileTraversalService fileTraversalService;
    @RequestMapping ("/loadFile")
    public ArrayList<String> LoadFile(ServletRequest servletRequest){
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String jwt = req.getHeader("token");
        Claims claims = JwtUtils.ParseJwt(jwt);
        return fileTraversalService.TraverseFiles("UploadFile\\" + claims.get("id").toString());
    }
}
