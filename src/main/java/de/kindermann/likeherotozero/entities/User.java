package de.kindermann.likeherotozero.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * Represents a user in the system.
 * This class is annotated with JPA annotations to indicate that it is an entity
 * and should be mapped to a database table named "users".
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role roleId;

    public User() {}

    public User(String email, String password, Role roleId) {
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        User user = (User) obj;
        return id == user.id;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

