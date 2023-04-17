package ysu.szx.ysuacmoj.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//Not used
//@WebFilter(urlPatterns = "/*")
public class SmallFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("in DoFilter");

        filterChain.doFilter(servletRequest, servletResponse);//放行


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
