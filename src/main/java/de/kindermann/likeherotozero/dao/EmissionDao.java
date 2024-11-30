package de.kindermann.likeherotozero.dao;


import de.kindermann.likeherotozero.entities.Emission;
import de.kindermann.likeherotozero.entities.Role;
import de.kindermann.likeherotozero.utils.EmissionStatus;
import de.kindermann.likeherotozero.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Data Access Object (DAO) for managing emission records in the database.
 *
 * This class provides methods to perform CRUD operations on the Emission entity.
 * It leverages JPA for persistence operations.
 */
public class EmissionDao {

    public List<Emission> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<Emission> query = em.createQuery("SELECT e FROM Emission e", Emission.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void approve(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Emission emission = em.find(Emission.class, id);
        emission.setStatus(EmissionStatus.ACTIVE.getIntStatus());
        em.persist(emission);
        em.getTransaction().commit();
    }

    public void delete(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Emission emission = em.find(Emission.class, id);
        em.remove(emission);
        em.getTransaction().commit();
    }

    public List<Emission> findAllByStatus(Integer status) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<Emission> query = em.createQuery("SELECT e FROM Emission e WHERE status = :status", Emission.class)
                    .setParameter("status", status);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void save(Emission emission) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(emission);
        em.getTransaction().commit();
    }
}
