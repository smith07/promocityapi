package com.azeka.promocityapi.com.azeka.promocityapi.configuration;
import com.azeka.promocityapi.com.azeka.promocityapi.dao.UserRepository;
import com.azeka.promocityapi.com.azeka.promocityapi.service.UserDetailServiceImpl;
import com.azeka.promocityapi.com.azeka.promocityapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class BeansConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserService getUserService(){
        return new UserService(userRepository, bCryptPasswordEncoder());
    }

    @Bean
    UserDetailsService getUserDetailService(){
        return new UserDetailServiceImpl(getUserService());
    }



}
