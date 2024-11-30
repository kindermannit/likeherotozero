package de.kindermann.likeherotozero.beans;

import at.favre.lib.crypto.bcrypt.BCrypt;
import de.kindermann.likeherotozero.dao.UserDao;
import de.kindermann.likeherotozero.entities.Role;
import de.kindermann.likeherotozero.entities.User;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

/**
 * Managed bean responsible for handling user-related operations within a request-scoped lifecycle.
 *
 * The UserBean class is annotated with @Named and @RequestScoped to allow it to be used in JSF pages
 * for managing user data. It provides the ability to add new users and retrieve all existing users
 * from the system.
 *
 * Internally, this class utilizes a UserDao instance to perform data access operations related to users.
 * It also relies on a RoleBean to assign roles to users during the user creation process.
 */
@Named
@RequestScoped
public class UserBean {
    private final UserDao dao = new UserDao();

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Integer roleId;

    @Inject
    private RoleBean roleBean;


    public UserBean() {}

    public String addUser() {
        System.out.println("addUser");
        Role role = this.roleBean.get(this.roleId);
        User newUser = new User(this.email, BCrypt.withDefaults().hashToString(12, this.password.toCharArray()), role);
        newUser.setFirstname(this.firstname);
        newUser.setLastname(this.lastname);
        this.dao.save(newUser);
        return "users_index?faces-redirect=true";
    }

    public List<User> allUsers() {
        return dao.findAll();
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
