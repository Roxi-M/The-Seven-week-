package com.roxi.inter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Roxi酱
 */
@WebFilter(value = "/class" ,filterName = "/haha")
public class MajorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("看一看开始没");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String student="student";
        System.out.println("class 过滤器");
        if(session.getAttribute(student)!=null){
            filterChain.doFilter(request,response);
        }else {
            response.getWriter().write("请去login登陆");
        }

    }

    @Override
    public void destroy() {

    }
}
