package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.EmissionDao;
import de.kindermann.likeherotozero.entities.Country;
import de.kindermann.likeherotozero.entities.Emission;
import de.kindermann.likeherotozero.utils.EmissionStatus;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

/**
 * EmissionBean is a managed bean that handles operations related to emission records.
 * It is responsible for adding new emissions, retrieving lists of emissions based on
 * their approval status, and managing emission records within the system.
 * The bean operates within a request-scoped context and interacts primarily with the
 * EmissionDao for data persistence and retrieval.
 *
 * Annotations:
 * - @Named declares that this class can be accessed in a JSF context with a specific name.
 * - @RequestScoped specifies that the bean's lifecycle corresponds to a single HTTP request.
 *
 * Dependencies:
 * - EmissionDao for data access operations.
 * - CountryBean for retrieving country information associated with emissions.
 * - PermissionBean for checking permissions related to emission operations.
 *
 * Fields:
 * - year: The year when the emission was recorded.
 * - tons: The quantity of emissions in tons.
 * - countryId: The unique identifier for the country associated with the emission.
 * - emissionStatusList: A list of possible statuses that an emission can have.
 *
 * Methods:
 * - addEmission: Adds a new emission entry to the system. Sets the status to ACTIVE
 *   if the user has permission to approve emissions; otherwise, sets it to PENDING.
 * - allApprovedEmissions: Retrieves all emissions with an ACTIVE status.
 * - allEmissions: Retrieves all emission records from the database.
 * - deleteEmission: Deletes a specified emission record by its ID.
 * - approveEmission: Approves a specified emission record by setting its status to ACTIVE.
 * - Getter and setter methods for the year, tons, and countryId fields.
 * - getEmissionStatusList: Returns all possible emission statuses.
 * - getPendingStatusId: Returns the integer representation of the PENDING status.
 */
@Named
@RequestScoped
public class EmissionBean {
    private final EmissionDao dao = new EmissionDao();
    private List<EmissionStatus> emissionStatusList;

    private Integer year;
    private Float tons;
    private Integer countryId;

    @Inject
    private CountryBean countryBean;

    @Inject
    private PermissionBean permissionBean;


    public EmissionBean() {}

    public String addEmission() {
        Country country = this.countryBean.get(this.countryId);
        Emission newEmission = new Emission(country, this.year, this.tons);
        if (permissionBean.canApprove("Emission")) {
            newEmission.setStatus(EmissionStatus.ACTIVE.getIntStatus());
        } else {
            newEmission.setStatus(EmissionStatus.PENDING.getIntStatus());
        }
        this.dao.save(newEmission);
        return "index?faces-redirect=true";
    }

    public List<Emission> allApprovedEmissions() {return dao.findAllByStatus(EmissionStatus.ACTIVE.getIntStatus());}
    public List<Emission> allEmissions() {
        return dao.findAll();
    }

    public String deleteEmission(Emission emission) {
        dao.delete(emission.getId());
        return "index?faces-redirect=true";
    }

    public String approveEmission(Emission emission) {
        dao.approve(emission.getId());
        return "index?faces-redirect=true";
    }

    public Float getTons() {
        return tons;
    }

    public void setTons(Float tons) {
        this.tons = tons;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getCountryId() {
        return countryId;
    }
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
    public EmissionStatus[] getEmissionStatusList() {
        return EmissionStatus.values();
    }
    public Integer getPendingStatusId() {
        return EmissionStatus.PENDING.getIntStatus();
    }
}
