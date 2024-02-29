package com.common;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class TestFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("TestFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
    	System.out.println("TestFilter doFilter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        System.out.println(httpRequest.getRequestURI());
        chain.doFilter(request, response); 
    }

    @Override
    public void destroy() {
    	System.out.println("TestFilter init");
    }
}