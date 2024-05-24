package com.example.astonhibernate.service;

import com.example.astonhibernate.dto.ClothesDto;

import java.util.List;

public interface ClothesService {

    ClothesDto creat(ClothesDto clothesDto);

    ClothesDto update(Long userId, ClothesDto clothesDto);

    ClothesDto findById(Long id);

    List<ClothesDto> findAll();

    void delete(Long id);
}
