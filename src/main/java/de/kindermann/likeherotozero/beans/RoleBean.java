package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.RoleDao;
import de.kindermann.likeherotozero.entities.Role;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class RoleBean {
    private final RoleDao dao = new RoleDao();

    public RoleBean() {}

    public List<Role> allRoles() {
        return dao.findAll();
    }
    public Role get(Integer id) {
        return dao.findById(id);
    }
}
