package com.azeka.promocityapi.com.azeka.promocityapi.service;

import com.azeka.promocityapi.com.azeka.promocityapi.dao.UserRepository;
import com.azeka.promocityapi.com.azeka.promocityapi.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository =  userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Transactional
    public Optional<AppUser> findUser(String mail){
        return userRepository.findById(mail);
    }

    public void saveUser(AppUser appUser){
        String passwordEncode =bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(passwordEncode);
        userRepository.save(appUser);
    }
}
