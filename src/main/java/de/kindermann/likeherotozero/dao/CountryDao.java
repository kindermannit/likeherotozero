package de.kindermann.likeherotozero.dao;


import de.kindermann.likeherotozero.entities.Country;
import de.kindermann.likeherotozero.entities.Emission;
import de.kindermann.likeherotozero.entities.User;
import de.kindermann.likeherotozero.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * The CountryDao class provides data access operations related to
 * the Country entity. It includes methods for retrieving all countries,
 * finding a country by its unique identifier, and saving a new country
 * to the database.
 */
public class CountryDao {

    public List<Country> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Country findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Country.class, id);
        } finally {
            em.close();
        }
    }

    public void save(Country country) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
    }
}
