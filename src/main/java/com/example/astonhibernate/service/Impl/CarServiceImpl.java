package com.example.astonhibernate.service.Impl;

import com.example.astonhibernate.dto.CarDto;
import com.example.astonhibernate.entity.Car;
import com.example.astonhibernate.entity.User;
import com.example.astonhibernate.mapper.CarMapper;
import com.example.astonhibernate.repository.CarRepository;
import com.example.astonhibernate.repository.UserRepository;
import com.example.astonhibernate.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMapper carMapper;
    private final CarRepository carRepository;
    private final UserRepository userRepository;


    @Override
    public CarDto creat(CarDto carDto) {
        Car car = carMapper.toEntity(carDto);
        return carMapper.toDto(carRepository.creat(car));
    }

    @Override
    public CarDto update(Long userId, CarDto carDto) {
        Car carBD = carRepository.findById(carDto.getId()).orElseThrow(()-> new RuntimeException("Car not found"));

        User user = null;
        if (userId != null) {
            user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        }
        carBD.setModel(carDto.getModel());
        carBD.setType(carDto.getType());
        carBD.setUser(user);

        userRepository.update(user);

        carRepository.update(carBD);
        return carMapper.toDto(carBD);
    }

    @Override
    public CarDto findById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        return carMapper.toDto(car);
    }

    @Override
    public List<CarDto> findAll() {
        return carMapper.toDto(carRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        Car car = carRepository.findById(id).orElseThrow(()-> new RuntimeException("Car not found"));
        carRepository.delete(car);
    }
}
