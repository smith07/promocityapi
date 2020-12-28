package com.azeka.promocityapi.com.azeka.promocityapi.configuration;

import com.azeka.promocityapi.com.azeka.promocityapi.model.AppUser;
import com.azeka.promocityapi.com.azeka.promocityapi.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthentificationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AppUser appUser = null;
        try {
            appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("******" + appUser.getMail());
        System.out.println("******" + appUser.getPassword());

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getMail(), appUser.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User)authResult.getPrincipal();
        String jwtToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+ Constants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, Constants.SECRET)
                .claim("roles", user.getAuthorities())
                .compact();
        response.addHeader(Constants.HEADER_STRING, Constants.TOKEN_PREFIX + jwtToken);

        //super.successfulAuthentication(request, response, chain, authResult);
    }
}
