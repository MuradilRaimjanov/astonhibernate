package com.example.astonhibernate.service.Impl;

import com.example.astonhibernate.dto.ClothesDto;
import com.example.astonhibernate.entity.Car;
import com.example.astonhibernate.entity.Clothes;
import com.example.astonhibernate.entity.User;
import com.example.astonhibernate.mapper.ClothesMapper;
import com.example.astonhibernate.repository.ClothesRepository;
import com.example.astonhibernate.repository.UserRepository;
import com.example.astonhibernate.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;
    private final ClothesMapper clothesMapper;
    private final UserRepository userRepository;

    @Override
    public ClothesDto creat(ClothesDto clothesDto) {
        Clothes clothes = clothesMapper.toEntity(clothesDto);
        return clothesMapper.toDto(clothesRepository.creat(clothes));
    }

    @Override
    public ClothesDto update(Long userId, ClothesDto clothesDto) {
        Clothes clothesBD = clothesRepository.findById(clothesDto.getId()).orElseThrow(()-> new RuntimeException("Clothes not found"));

        User user = null;
        if (userId != null) {
            user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        }
        clothesBD.setName(clothesDto.getName());
        clothesBD.setType(clothesDto.getType());
        clothesBD.setUser(user);

        userRepository.update(user);

        clothesRepository.update(clothesBD);
        return clothesMapper.toDto(clothesBD);
    }

    @Override
    public ClothesDto findById(Long id) {
        Clothes clothes = clothesRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        return clothesMapper.toDto(clothes);
    }

    @Override
    public List<ClothesDto> findAll() {
        return clothesMapper.toDto(clothesRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        Clothes clothes = clothesRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        clothesRepository.delete(clothes);
    }
}
