package de.kindermann.likeherotozero.dao;


import de.kindermann.likeherotozero.entities.User;
import de.kindermann.likeherotozero.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * The UserDao class provides CRUD operations for the User entity.
 * It interacts with the database to perform actions like finding users
 * by email, retrieving all users, and saving a new user to the database.
 */
public class UserDao {
    public User findByEmail(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = :email ", User.class)
                .setParameter("email", email)
                .getResultList();
        return users.isEmpty() ? null : users.getFirst();
    }

    public List<User> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void save(User user) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
