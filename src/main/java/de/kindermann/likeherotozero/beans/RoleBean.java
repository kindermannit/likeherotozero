package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.RoleDao;
import de.kindermann.likeherotozero.entities.Role;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

/**
 * Managed bean responsible for handling role-related operations
 * within a request-scoped lifecycle.
 *
 * The RoleBean class is annotated with @Named and @RequestScoped
 * to allow it to be used in JSF pages for managing roles data.
 *
 * Internally, this class utilizes a RoleDao instance to perform
 * data access operations related to roles.
 */
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
