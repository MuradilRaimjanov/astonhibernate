package com.example.astonhibernate.repository;


import com.example.astonhibernate.entity.Clothes;

import java.util.List;
import java.util.Optional;

public interface ClothesRepository {

    Clothes creat(Clothes clothes);

    void update(Clothes clothes);

    Optional<Clothes> findById(Long id);

    List<Clothes> findAll();

    void delete(Clothes clothes);
}
