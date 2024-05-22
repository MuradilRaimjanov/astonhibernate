package com.example.astonhibernate.service;
import com.example.astonhibernate.entity.User;
import com.example.astonhibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final SessionFactory sessionFactory;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    public User getUserById(Long id) {
      Session session = sessionFactory.getCurrentSession();
      return session.get(User.class, id);
    }

    @Transactional
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Transactional
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.detach(user);
    }
}
