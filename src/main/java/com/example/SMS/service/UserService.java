package com.example.SMS.service;

import com.example.SMS.dto.UserDto;
import com.example.SMS.model.User;
import com.example.SMS.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto createUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto,User.class));
        return userDto;
    }

    public UserDto updateUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto,User.class));
        return  userDto;
    }
    public String deleteUser(UserDto userDto){
        userRepo.delete(modelMapper.map(userDto, User.class));
        return "User Deleted";
    }

    public int deleteUserByID(Integer id){
        userRepo.deleteById(id);
        return 1;
    }
}
