package com.example.astonhibernate.repository;

import com.example.astonhibernate.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    Car creat(Car car);

    void update(Car car);

    Optional<Car> findById(Long id);

    List<Car> findAll();

    void delete(Car car);
}
