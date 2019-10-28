package com.salon.controller;

import com.salon.service.UserService;
import com.salon.shared.dto.UserDto;
import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser(){
        return "get some user ...";
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse=new UserResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest,userDto);

        UserDto createdUser=userService.createUser(userDto);

        BeanUtils.copyProperties(createdUser,userResponse);

        return userResponse;
    }

    @PutMapping
    public String updateUser(){
        return "put update some user ...";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete delete some user ...";
    }
}
