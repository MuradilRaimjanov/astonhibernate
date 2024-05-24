package com.example.astonhibernate.controller;

import com.example.astonhibernate.dto.CarDto;
import com.example.astonhibernate.dto.ClothesDto;
import com.example.astonhibernate.entity.Clothes;
import com.example.astonhibernate.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clothes")
@RequiredArgsConstructor
public class ClothesRepository {

    private final ClothesService clothesService;


    @PostMapping()
    public ResponseEntity<ClothesDto> create(@RequestBody ClothesDto clothesDto) {
        return ResponseEntity.ok(clothesService.creat(clothesDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ClothesDto> update(@PathVariable Long userId, @RequestBody ClothesDto clothesDto) {
        ClothesDto clothesUpdate = clothesService.update(userId, clothesDto);
        return ResponseEntity.ok(clothesDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClothesDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clothesService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ClothesDto>> findAll() {
        return ResponseEntity.ok(clothesService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        clothesService.delete(id);
        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }
}
