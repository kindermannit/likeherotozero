package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.PermissionDao;
import de.kindermann.likeherotozero.dao.UserDao;
import de.kindermann.likeherotozero.entities.User;
import de.kindermann.likeherotozero.utils.SessionUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

import java.io.Serializable;

@Named
@SessionScoped
public class PermissionBean implements Serializable {

    public PermissionBean() {}

    public boolean isLoggedIn() {
        HttpSession session = SessionUtils.getSession();
        return session.getAttribute("userEmail") != null;
    }
    public boolean canCreate(String entity) {
        String email = SessionUtils.getUserEmail();
        if (email == null) {
            return false;
        }
        UserDao userDao = new UserDao();
        User user = userDao.findByEmail(email);
        PermissionDao permissionDao = new PermissionDao();
        return permissionDao.canCreate(user.getRoleId(), entity);

    }
    public boolean canApprove(String entity) {
        String email = SessionUtils.getUserEmail();
        if (email == null) {
            return false;
        }
        UserDao userDao = new UserDao();
        User user = userDao.findByEmail(email);
        PermissionDao permissionDao = new PermissionDao();
        return permissionDao.canApprove(user.getRoleId(), entity);
    }
}
