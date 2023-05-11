package com.mohacel.education.controller;

import com.mohacel.education.dto.UserDto;
import com.mohacel.education.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService service;

    //POST--create user
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto saveUser = service.saveUser(userDto);
        return  new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }


    //GET--get user
    @GetMapping("/user/{id}")
    public  ResponseEntity<UserDto> getById(@PathVariable Integer id){
        UserDto singleUser = service.getSingleUser(id);
        return new ResponseEntity<>(singleUser, HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = service.getAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    //PUT--update user
    @PutMapping("/user/{id}")
    public  ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer id ){
        UserDto updateUser = service.updateUser(userDto, id);
        return  new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    //DELETE--delete user
    @DeleteMapping("/user/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable Integer id){
        String msg = service.deleteUser(id);
        return  new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
