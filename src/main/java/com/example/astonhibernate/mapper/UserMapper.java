package com.example.astonhibernate.mapper;

import com.example.astonhibernate.dto.UserDto;
import com.example.astonhibernate.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto>{
}
