package de.kindermann.likeherotozero.beans;

import de.kindermann.likeherotozero.dao.CountryDao;
import de.kindermann.likeherotozero.entities.Country;
import de.kindermann.likeherotozero.entities.Role;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

/**
 * CountryBean is a managed bean for handling operations related to Country entities.
 * It is responsible for adding new countries and retrieving existing ones.
 * The bean is accessible in a request-scoped context.
 */
@Named
@RequestScoped
public class CountryBean {
    private final CountryDao dao = new CountryDao();

    private String name;
    private String iso3;

    public CountryBean() {}

    public String addCountry() {
        Country newCountry = new Country(this.name, this.iso3.toUpperCase());
        this.dao.save(newCountry);
        return "countries_index?faces-redirect=true";
    }

    public List<Country> allCountries() {
        return dao.findAll();
    }
    public Country get(Integer id) {
        return dao.findById(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }
}
