package com.example.astonhibernate.service;

import com.example.astonhibernate.dto.CarDto;

import java.util.List;

public interface CarService {

    CarDto creat(CarDto carDto);

    CarDto update(Long userId, CarDto carDto);

    CarDto findById(Long id);

    List<CarDto> findAll();

    void delete(Long id);
}
