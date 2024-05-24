package com.example.astonhibernate.mapper;

import com.example.astonhibernate.dto.ClothesDto;
import com.example.astonhibernate.entity.Clothes;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClothesMapper extends Mappable<Clothes, ClothesDto> {
}
