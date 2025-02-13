package org.example.scheduledevelop.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = "/schedules/*")  // /schedules/* 경로만 필터링
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        // 로그인 및 회원가입 요청은 인증 처리에서 제외
        String requestURI = httpRequest.getRequestURI();
        if (requestURI.startsWith("/auth/login") || requestURI.startsWith("/auth/signup")) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 인증 여부 체크: 세션에서 "userEmail"을 확인
        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 (현재는 비어 있음)
    }

    @Override
    public void destroy() {
        // 필터 종료 (현재는 비어 있음)
    }
}


