package com.qqzone.mySpringMvc.filters;


import com.qqzone.Util.StringUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alitar
 * @date 2023-02-01 19:07
 */
//@WebFilter("*.do")
public class CharacterEncodingFilters implements Filter {

    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        String encodingStr = filterConfig.getInitParameter("encoding");
        if (StringUtil.isNoEmpty(encodingStr)){
            encoding= encodingStr;
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CharacterEncoding Filter ......");
        System.out.println(encoding);
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("CharacterEncoding Filter ok !");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}