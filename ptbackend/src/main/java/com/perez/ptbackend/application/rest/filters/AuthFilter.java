package com.perez.ptbackend.application.rest.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.perez.ptbackend.core.constants.Constant;
import com.perez.ptbackend.core.ports.inputs.UserService;
import com.perez.ptbackend.core.providers.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            String authorizationHeader = request.getHeader(Constant.HEADER_AUTHORIZATION_KEY);

            if (!StringUtils.hasText(authorizationHeader)
                    || !authorizationHeader.startsWith(Constant.TOKEN_BEARER_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            final String token =
                    authorizationHeader.replace(Constant.TOKEN_BEARER_PREFIX + " ", "");

            String username = tokenProvider.getUserName(token);
            UserDetails user = userService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken =
                    tokenProvider.getAuthentication(token, user);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);

    }

}
