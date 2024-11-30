package de.kindermann.likeherotozero.utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utility class for managing JPA EntityManagerFactory and EntityManagers.
 */
public class JpaUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeHeroToZeroPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
