package com.example.springsecurityexample.sts.filter;

import com.example.springsecurityexample.sts.repository.UsersRepository;
import com.example.springsecurityexample.sts.service.UserNameService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BasicAutenticationFilter extends OncePerRequestFilter {

    private static final String BASIC = "Basic ";

    private final UsersRepository repository;

    private final UserNameService userNameService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (isBasicAuthorization(extractAuthorizationBasic(request))) {

            String[] credentials = extractUsernameAndPasswordBasic(request);

            var userDetail = userNameService.loadUserByUsername(credentials[0]);

            if(Objects.isNull(userDetail)){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("User Not Found");
                return;
            }

            if (!validatePassword(credentials[1], userDetail.getPassword())) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Credentials UNAUTRORIZED");
                return;
            }

            var authenticationToken = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

        filterChain.doFilter(request, response);
    }

    private boolean validatePassword(String rawPassword, String encodePassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodePassword);
    }


    private boolean isBasicAuthorization(String authorization) {
        return StringUtils.isNotEmpty(authorization) && authorization.startsWith(BASIC);
    }

    private String extractAuthorizationBasic(HttpServletRequest request) {
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }

    private String[] extractUsernameAndPasswordBasic(HttpServletRequest request) {
        final var authorization = removePrefixBasicAuthorization(request);
        final var base64 = decoderAuthorizationToBase64(authorization);
        return base64.split(":");
    }

    private String removePrefixBasicAuthorization(HttpServletRequest request) {
        return extractAuthorizationBasic(request).replace(BASIC, "");
    }

    private String decoderAuthorizationToBase64(String authorization) {
        return new String(Base64.getDecoder().decode(authorization));
    }
}
