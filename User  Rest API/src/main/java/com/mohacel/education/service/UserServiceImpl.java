package com.mohacel.education.service;

import com.mohacel.education.dto.UserDto;
import com.mohacel.education.entity.UserEntity;
import com.mohacel.education.exception.UserResourcesNotFoundException;
import com.mohacel.education.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements IUserService{

    private UserRepository repository;
    public UserServiceImpl(UserRepository repository){
        this.repository =repository;
    }
    @Override
    public UserDto saveUser(UserDto user) {
        UserEntity userEntity = this.dto2user(user);
        UserEntity savedUser = this.repository.save(userEntity);
        return this.user2dto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        UserEntity user = repository.findById(id)
                .orElseThrow(()-> new UserResourcesNotFoundException("User", "Id", id));

        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());

        UserEntity updatedUser = this.repository.save(user);
        UserDto dto = this.user2dto(updatedUser);
        return dto;
    }

    @Override
    public String deleteUser(Integer id) {
        UserEntity user = this.repository.findById(id).orElseThrow(() -> new UserResourcesNotFoundException("User", "Id", id));
        this.repository.delete(user);
        return "User Deleted Successfully..";
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> entityList = this.repository.findAll();
        List<UserDto> userDtoList = entityList.stream().map(user -> this.user2dto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto getSingleUser(Integer id) {
        UserEntity user = repository.findById(id)
                .orElseThrow(()-> new UserResourcesNotFoundException("User", "Id", id));

        return this.user2dto(user);
    }



    private UserEntity dto2user(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        return user;
    }

    private UserDto user2dto (UserEntity user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        return dto;
    }
}
