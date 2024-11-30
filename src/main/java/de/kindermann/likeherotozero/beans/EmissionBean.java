package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.EmissionDao;
import de.kindermann.likeherotozero.entities.Country;
import de.kindermann.likeherotozero.entities.Emission;
import de.kindermann.likeherotozero.utils.EmissionStatus;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

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
