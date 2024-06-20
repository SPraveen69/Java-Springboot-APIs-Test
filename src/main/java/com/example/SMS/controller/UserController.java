package com.example.SMS.controller;

import com.example.SMS.dto.UserDto;
import com.example.SMS.model.User;
import com.example.SMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUser")
    public String getUser(){
        return "One user";
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody UserDto userDto){
        return userService.deleteUser(userDto);

    }

//    @DeleteMapping("/deleteUserByID/{userId}")
//    public int deleteUserByID(@PathVariable int userId){
//        return userService.deleteUserByID(userId);
//
//    }

    @DeleteMapping("/deleteUserByID/{id}")
    public int deleteUserByID(@PathVariable int id){
        return userService.deleteUserByID(id);

    }
}
