package com.example.astonhibernate.service.Impl;

import com.example.astonhibernate.dto.UserDto;
import com.example.astonhibernate.entity.Car;
import com.example.astonhibernate.entity.User;
import com.example.astonhibernate.mapper.UserMapper;
import com.example.astonhibernate.repository.CarRepository;
import com.example.astonhibernate.repository.UserRepository;
import com.example.astonhibernate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CarRepository carRepository;


    @Override
    public UserDto creat(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.creat(user));
    }

    @Override
    public UserDto update(Long carId, UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Car car = null;
        if (carId != null) {
            car = carRepository.findById(carId).orElseThrow(()-> new RuntimeException("Car not found"));
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCar(car);

        carRepository.update(car);

        User userUpdate = userRepository.update(user);
        return userMapper.toDto(userUpdate);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
