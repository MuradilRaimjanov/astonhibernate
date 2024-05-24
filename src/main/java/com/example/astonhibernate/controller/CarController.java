package com.example.astonhibernate.controller;

import com.example.astonhibernate.dto.CarDto;
import com.example.astonhibernate.dto.UserDto;
import com.example.astonhibernate.repository.CarRepository;
import com.example.astonhibernate.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    @PostMapping()
    public ResponseEntity<CarDto> create(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.creat(carDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CarDto> update(@PathVariable Long userId, @RequestBody CarDto carDto) {
        CarDto carUpdate = carService.update(userId, carDto);
        return ResponseEntity.ok(carUpdate);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        carService.delete(id);
        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }

}
