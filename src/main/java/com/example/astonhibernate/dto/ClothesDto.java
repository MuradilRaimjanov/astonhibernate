package com.example.astonhibernate.dto;

import com.example.astonhibernate.entity.User;
import lombok.Data;

@Data
public class ClothesDto {

    private Long id;
    private String name;
    private String type;
    private User user;
}
