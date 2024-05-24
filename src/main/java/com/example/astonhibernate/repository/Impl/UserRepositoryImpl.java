package com.example.astonhibernate.repository.Impl;
import com.example.astonhibernate.entity.User;
import com.example.astonhibernate.repository.UserRepository;
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
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public User creat(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }
    @Override
    @Transactional
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    @Override
    @Transactional
    public Optional<User> findById(Long id) {
      Session session = sessionFactory.getCurrentSession();
      Optional<User> user = Optional.ofNullable(session.get(User.class, id));
      return user;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.detach(user);
    }
}
