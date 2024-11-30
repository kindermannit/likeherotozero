package de.kindermann.likeherotozero.entities;

import jakarta.persistence.*;

/**
 * Represents a permission associated with a specific role in the system.
 * This class is annotated with JPA annotations to indicate that it is an entity
 * and should be mapped to a database table named "permissions".
 *
 * The permission defines various actions that can be performed such as create, update, delete, and approve on a specific entity.
 */
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String entity;
    private Boolean canCreate;
    private Boolean canUpdate;
    private Boolean canDelete;
    private Boolean canApprove;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role roleId;

    public Permission() {}

    public Permission(Role roleId) {
        this.roleId = roleId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Boolean canCreate) {
        this.canCreate = canCreate;
    }

    public Boolean getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getCanApprove() {
        return canApprove;
    }

    public void setCanApprove(Boolean canApprove) {
        this.canApprove = canApprove;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    // hashCode and equals based on id
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Permission permission = (Permission) obj;
        return id == permission.id;
    }

    // toString method
    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", role_id='" + roleId + '\'' +
                ", can_update='" + canUpdate + '\'' +
                ", can_create='" + canCreate + '\'' +
                ", can_delete='" + canDelete + '\'' +
                ", can_approve='" + canApprove + '\'' +
                '}';
    }
}

