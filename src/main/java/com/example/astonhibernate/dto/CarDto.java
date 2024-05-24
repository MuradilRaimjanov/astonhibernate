package com.example.astonhibernate.dto;

import com.example.astonhibernate.entity.User;
import lombok.*;

@Data
public class CarDto {

    private Long id;
    private String model;
    private String type;
    private User user;
}
