package com.hae.global.jwt.filter;

import com.hae.global.jwt.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;


@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain){
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String accessToken= authHeader.substring(7);

            String userId=jwtUtil.extractUserId(accessToken);
            log.info("[Auth] auth user: {}", userId);
            if(userId != null){
                log.info("[Auth] userId: {}의 권한이 인증되었습니다.", userId);
                setAuthentication(accessToken);
            }
        }
        else{
            log.info("[Jwt] 헤더에 엑세스 토큰이 포함되어 있지 않습니다. ");
        }
        try{
            filterChain.doFilter(request, response);
        }
        catch (IOException | ServletException e){
            log.error("jwt filter exception : {} ", e.getMessage());
        }
    }

    private void setAuthentication(String token){
        SecurityContextHolder.getContext().setAuthentication(createAuthentication(token));
    }

    private UsernamePasswordAuthenticationToken createAuthentication(String token){
        UserDetails userDetails= null;
        UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails, "",userDetails.getAuthorities());
        authToken.setDetails(userDetails);
        return authToken;
    }
}
