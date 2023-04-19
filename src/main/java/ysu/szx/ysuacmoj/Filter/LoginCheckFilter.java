package ysu.szx.ysuacmoj.Filter;


import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import ysu.szx.ysuacmoj.Pojo.Results;
import ysu.szx.ysuacmoj.Utils.JwtUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        String url = req.getRequestURL().toString();
        System.out.println(url);
//        System.out.println(req);
//        filterChain.doFilter(servletRequest, servletResponse);//放行
        if(url.contains("http://localhost:9000/regist") || url.contains("http://localhost:9000/login")){
            filterChain.doFilter(servletRequest, servletResponse);//放行
            return;
        }
        String jwt = req.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            Results res = Results.Error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(res);
            resp.getWriter().write(notLogin);
            return;
        }

        try{
            JwtUtils.ParseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
//            log.info("解析令牌失败");
            Results res = Results.Error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(res);
            resp.getWriter().write(notLogin);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);//放行
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}