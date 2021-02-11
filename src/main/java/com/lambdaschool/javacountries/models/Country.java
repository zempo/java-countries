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
}
