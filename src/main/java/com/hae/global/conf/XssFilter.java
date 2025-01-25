package com.hae.global.conf;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class XssFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 요청을 XSS 필터링된 래퍼로 감싸기
        XssRequestWrapper wrappedRequest = new XssRequestWrapper(httpRequest);

        // 다음 필터로 전달
        chain.doFilter(wrappedRequest, response);
    }
}
