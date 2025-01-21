package com.hae.web.has.user.service;


import com.hae.web.global.jwt.util.JwtUtil;
import com.hae.web.has.user.dto.PrincipalDetails;
import com.hae.web.has.user.model.EsaUser;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Builder
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String access) throws UsernameNotFoundException{
        if(!jwtUtil.validateToken(access)){
            log.info("Invalid access token");
            return null;
        }
        return new PrincipalDetails(
                EsaUser.builder()
                        .sysId(jwtUtil.extractId(access))
                        .usrId(jwtUtil.extractUserId(access))
                        .usrNm(jwtUtil.extractUsername(access))
                        .jobRole(jwtUtil.extractUserRole(access))
                        .build()
        );


    }
}
