package com.example.astonhibernate.repository.Impl;

import com.example.astonhibernate.entity.Car;
import com.example.astonhibernate.entity.Clothes;
import com.example.astonhibernate.repository.ClothesRepository;
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
public class ClothesRepositoryImpl implements ClothesRepository {

    private final SessionFactory sessionFactory;



    @Override
    @Transactional
    public Clothes creat(Clothes clothes) {
        Session session = sessionFactory.getCurrentSession();
        session.save(clothes);
        return clothes;
    }

    @Override
    @Transactional
    public void update(Clothes clothes) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(clothes);
    }

    @Override
    @Transactional
    public Optional<Clothes> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Optional<Clothes> clothes = Optional.ofNullable(session.get(Clothes.class, id));
        return clothes;
    }

    @Override
    @Transactional
    public List<Clothes> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Clothes> query = session.createQuery("FROM Clothes", Clothes.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(Clothes clothes) {
        Session session = sessionFactory.getCurrentSession();
        session.detach(clothes);
    }
}
