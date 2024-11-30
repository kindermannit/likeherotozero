package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.UserDao;
import de.kindermann.likeherotozero.entities.User;

import de.kindermann.likeherotozero.utils.SessionUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import at.favre.lib.crypto.bcrypt.*;
import jakarta.servlet.http.HttpSession;

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
