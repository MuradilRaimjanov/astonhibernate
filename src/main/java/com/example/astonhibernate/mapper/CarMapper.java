package com.example.astonhibernate.mapper;

import com.example.astonhibernate.dto.CarDto;
import com.example.astonhibernate.entity.Car;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CarMapper extends Mappable<Car, CarDto>{
}
