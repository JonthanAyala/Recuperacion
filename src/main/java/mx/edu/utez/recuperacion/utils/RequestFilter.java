package mx.edu.utez.recuperacion.utils;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = {"/*"})
public class RequestFilter implements Filter {
    List<String> whiteList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Endpoints publicos
        whiteList.add("/");
        whiteList.add("/user/login");
        whiteList.add("/user/view-login");

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String action = request.getServletPath();
        System.out.println(action);
        if (whiteList.contains(action)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/user/view-login");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
