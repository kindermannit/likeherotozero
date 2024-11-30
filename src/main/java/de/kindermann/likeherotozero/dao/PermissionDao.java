package de.kindermann.likeherotozero.dao;


import de.kindermann.likeherotozero.entities.Permission;
import de.kindermann.likeherotozero.entities.Role;
import de.kindermann.likeherotozero.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PermissionDao {

    public boolean canUpdate(Role role, String entity) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Permission> permissions = em.createQuery("SELECT p FROM Permission p WHERE p.roleId = :roleId AND p.entity = :entity ", Permission.class)
                .setParameter("roleId", role)
                .setParameter("entity", entity)
                .getResultList();
        return !permissions.isEmpty() && permissions.getFirst().getCanUpdate();
    }

    public boolean canCreate(Role role, String entity) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Permission> permissions = em.createQuery("SELECT p FROM Permission p WHERE p.roleId = :roleId AND p.entity = :entity ", Permission.class)
                .setParameter("roleId", role)
                .setParameter("entity", entity)
                .getResultList();
        return !permissions.isEmpty() && permissions.getFirst().getCanCreate();
    }

    public boolean canDelete(Role role, String entity) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Permission> permissions = em.createQuery("SELECT p FROM Permission p WHERE p.roleId = :roleId AND p.entity = :entity ", Permission.class)
                .setParameter("roleId", role)
                .setParameter("entity", entity)
                .getResultList();
        return !permissions.isEmpty() && permissions.getFirst().getCanDelete();
    }

    public boolean canApprove(Role role, String entity) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Permission> permissions = em.createQuery("SELECT p FROM Permission p WHERE p.roleId = :roleId AND p.entity = :entity ", Permission.class)
                .setParameter("roleId", role)
                .setParameter("entity", entity)
                .getResultList();
        return !permissions.isEmpty() && permissions.getFirst().getCanApprove();
    }


}
