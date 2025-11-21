package org.example.filters;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;



@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("[LOG BEFORE] " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);

        System.out.println("[LOG AFTER] " + req.getMethod() + " " + req.getRequestURI());
    }
}

