package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.UserDao;
import de.kindermann.likeherotozero.entities.User;

import de.kindermann.likeherotozero.utils.SessionUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import at.favre.lib.crypto.bcrypt.*;
import jakarta.servlet.http.HttpSession;

/**
 * The AuthBean class is a managed bean used for handling user authentication
 * in a web application environment. It serves as a session-scoped bean, ensuring
 * that the user's authentication state is maintained throughout their session.
 *
 * This class provides methods for logging in and out a user. The login method
 * validates user credentials against the database and starts a session if the
 * credentials are correct. The logout method invalidates the user session.
 */
@Named
@SessionScoped
public class AuthBean implements Serializable {
    private String email;
    private String password;

    public AuthBean() {}

    public String login() {
        UserDao userDao = new UserDao();
        User user = userDao.findByEmail(email);
        if (user != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword().toCharArray());
            if (!result.verified) {
                return "login?faces-redirect=true";
            } else {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("userEmail", email);
                return "index?faces-redirect=true";
            }
        } else {
            return "login?faces-redirect=true";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index?faces-redirect=true";
    }


    // Getters and setters
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
}
