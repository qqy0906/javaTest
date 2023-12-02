package com.example.staffmanager.demos.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("uriFormatFilter")
// OncePerRequestFilter，它能够确保在一次请求中只通过一次filter
public class UriFormatFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String uri = httpServletRequest.getRequestURI();
        String newUri = uri;
        if (uri.contains("/prod-api")) {
            newUri = uri.replace("/prod-api","/");
        }
        newUri = newUri.replaceAll("//","/");
        // 使用HttpServletRequestWrapper重写Request请求参数
        String finalNewUri = newUri;
        httpServletRequest = new HttpServletRequestWrapper(httpServletRequest){
            @Override
            public String getRequestURI() {
                return finalNewUri;
            }
        };
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}