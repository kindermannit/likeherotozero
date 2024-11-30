package de.kindermann.likeherotozero.entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Represents a role in the system.
 * This class is annotated with JPA annotations to indicate that it is an entity
 * and should be mapped to a database table named "roles".
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL)
    private Set<User> users;

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL)
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String email) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
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
        Role role = (Role) obj;
        return id == role.id;
    }

    // toString method
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}