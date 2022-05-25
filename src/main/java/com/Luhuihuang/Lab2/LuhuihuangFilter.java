package com.Luhuihuang.Lab2;

import javax.servlet.*;
import java.io.IOException;

public class LuhuihuangFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LuhuihuangFilter--->before chain");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("LuhuihuangFilter--->after chain");
    }

    @Override
    public void destroy() {

    }
}