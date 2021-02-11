package com.lambdaschool.javacountries.models;


import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryid;
    private String name;
    private long population;
    private long landmasskm2;
    private int medianage;

    public Country(String name, long population, long landmasskm2, int medianage) {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public long getCountryId() {
        return countryid;
    }

    public void setCountryId(long countryid) {
        this.countryid = countryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLandmasskm2() {
        return landmasskm2;
    }

    public void setLandmasskm2(long landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getMedianage() {
        return medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }
}
