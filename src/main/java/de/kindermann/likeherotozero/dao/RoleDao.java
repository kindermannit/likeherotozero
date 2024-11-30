package de.kindermann.likeherotozero.dao;


import de.kindermann.likeherotozero.entities.Role;
import de.kindermann.likeherotozero.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Data Access Object for performing operations on the Role entity.
 * This class provides methods to interact with the database for CRUD operations on roles.
 * It utilizes JPA's EntityManager to execute queries and manage role entities.
 */
public class RoleDao {

    public List<Role> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<Role> query = em.createQuery("SELECT u FROM Role u", Role.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Role findById(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Role.class, id);
        } finally {
            em.close();
        }
    }
}
