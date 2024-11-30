package de.kindermann.likeherotozero.entities;

import de.kindermann.likeherotozero.utils.EmissionStatus;
import jakarta.persistence.*;

/**
 * Represents an emission record within the system.
 *
 * An emission is defined by its year, the amount of emissions in tons, its
 * status, and the associated country.
 *
 * This entity is mapped to the "emissions" table in the database.
 *
 * Annotations:
 * - @Entity indicates that this class is a JPA entity.
 * - @Table specifies the table name in the database.
 * - @Id and @GeneratedValue define the primary key and its generation strategy.
 * - @ManyToOne and @JoinColumn define a many-to-one relationship with the Country entity.
 */
@Entity
@Table(name = "emissions")
public class Emission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int year;
    private float tons;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country countryId;

    public Emission() {}

    public Emission(Country countryId, Integer year, Float tons) {
        this.countryId = countryId;
        this.year = year;
        this.tons = tons;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getTons() {
        return tons;
    }

    public void setTons(float tons) {
        this.tons = tons;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public boolean isPending() {
       return this.status == EmissionStatus.PENDING.getIntStatus();
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
        Emission permission = (Emission) obj;
        return id == permission.id;
    }

    // toString method
    @Override
    public String toString() {
        return "Emission{" +
                "id=" + id +
                ", countryId='" + countryId + '\'' +
                ", tons='" + tons + '\'' +
                ", year='" + year + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

