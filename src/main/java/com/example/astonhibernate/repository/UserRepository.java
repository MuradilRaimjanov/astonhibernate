package com.example.astonhibernate.repository;



import com.example.astonhibernate.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User creat(User user);

    User update(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    void delete(User user);

}
