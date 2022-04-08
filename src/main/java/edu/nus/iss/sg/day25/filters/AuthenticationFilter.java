package edu.nus.iss.sg.day25.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        HttpSession session = httpRequest.getSession();
        String username = (String)session.getAttribute("name");

        System.out.println(">>> url: " + httpRequest.getRequestURI().toString());
        System.out.println(">>> name: " + username);

        if(username == null || username.trim().length() <= 0) {
            httpResponse.sendRedirect("/index.html");
            return;
        }

        chain.doFilter(request, response);
    }

}
