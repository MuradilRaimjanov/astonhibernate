package com.example.astonhibernate.repository.Impl;

import com.example.astonhibernate.entity.Car;
import com.example.astonhibernate.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {


    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public Car creat(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
        return car;
    }

    @Override
    @Transactional
    public void update(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Override
    @Transactional
    public Optional<Car> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Optional<Car> car = Optional.ofNullable(session.get(Car.class, id));
        return car;
    }

    @Override
    @Transactional
    public List<Car> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Car> query = session.createQuery("FROM Car", Car.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.detach(car);
    }
}
