package com.mohacel.education.service;

import com.mohacel.education.dto.UserDto;

import java.util.List;

public interface IUserService {
    public UserDto saveUser(UserDto user);
    public UserDto updateUser(UserDto userDto, Integer id);
    public String deleteUser(Integer id);
    public List<UserDto> getAll();
    public UserDto getSingleUser(Integer id);

}
