package com.azeka.promocityapi.com.azeka.promocityapi.configuration;

import com.azeka.promocityapi.com.azeka.promocityapi.utils.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JWTAuthorisationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader(Constants.HEADER_STRING);
        if(jwt == null || !jwt.startsWith(Constants.TOKEN_PREFIX)){
            filterChain.doFilter(request, response);
            return;
        }
        Claims claims = Jwts.parser()
                .setSigningKey(Constants.SECRET)
                .parseClaimsJws(jwt.replace(Constants.TOKEN_PREFIX, "")).getBody();
        String userName = claims.getSubject();
        List<Map<String, String>> roles = (List<Map<String, String>>)claims.get("roles");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.get("authority")));
        });

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userName, null,authorities );
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }
}
