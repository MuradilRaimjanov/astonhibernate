package com.example.astonhibernate.service;

import com.example.astonhibernate.dto.UserDto;
import com.example.astonhibernate.entity.User;

import java.util.List;

public interface UserService {

    UserDto creat(UserDto userDto);

    UserDto update(Long carId, UserDto userDto);

    UserDto findById(Long id);

    List<UserDto> findAll();

    void delete(Long id);


}
