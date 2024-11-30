package de.kindermann.likeherotozero.entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * The Country class represents a country entity with a unique identifier,
 * name, ISO3 code, and associated emissions.
 *
 * This entity is mapped to the "countries" table in the database.
 * It supports basic persistence operations as well as associations
 * with the Emission entity.
 *
 * Annotations:
 * - @Entity indicates that this class is a JPA entity.
 * - @Table specifies the table name in the database.
 * - @Id and @GeneratedValue define the primary key and its generation strategy.
 * - @OneToMany establishes a one-to-many relationship with the Emission entity.
 */
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String iso3;

    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL)
    private Set<Emission> emissions;

    public Country() {
    }

    public Country(String name, String iso3) {
        this.name = name;
        this.iso3 = iso3;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Emission> getEmissions() {
        return emissions;
    }

    public void setEmissions(Set<Emission> emissions) {
        this.emissions = emissions;
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
        Country country = (Country) obj;
        return id == country.id;
    }

    // toString method
    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iso3='" + iso3 + '\'' +
                '}';
    }
}
