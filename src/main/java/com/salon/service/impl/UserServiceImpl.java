package com.salon.service.impl;


import com.salon.common.Utils;
import com.salon.domain.User;
import com.salon.repository.impl.UserRepo;
import com.salon.service.UserService;
import com.salon.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Utils utils;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepo.findUserByEmail(user.getEmail())!= null){
            throw new RuntimeException("user with email: " + user.getEmail()
                    +" is already exists. Change your email address");
        }
        if(userRepo.findUserByUserName(user.getUserName())!= null){
            throw new RuntimeException("user with nick: " + user.getUserName()
                    +" is already exists. Change your nickname address");
        }
        if(user.getPhoneNumber() != null && userRepo.findUserByPhoneNumber(user.getPhoneNumber())!=null ){
            throw new RuntimeException("user with phone number: " + user.getPhoneNumber()
                    +" is already exists. Change your phone number");
        }

        User userCreate=new User();
        BeanUtils.copyProperties(user,userCreate);

        userCreate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userCreate.setUserId(utils.generateUserId(30));
        userCreate.setUserName(utils.getRandomUserName());

        User userDb=userRepo.save(userCreate);
        UserDto userReturn=new UserDto();

//        if(userDb==null){
//            throw new Exception("Cannot create user");
//        }

        BeanUtils.copyProperties(userDb,userReturn);
        return userReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User userByEmail = userRepo.findUserByEmail(email);
        if(userByEmail==null){
            throw new UsernameNotFoundException("User with email: "+email+" not found");
        }
        //return new org.springframework.security.core.userdetails.User(
        // userByEmail.getEmail(),userByEmail.getPassword(),new ArrayList<>());
        return userByEmail;
    }
}
