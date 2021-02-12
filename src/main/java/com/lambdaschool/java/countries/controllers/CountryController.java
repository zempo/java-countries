package com.lambdaschool.java.countries.controllers;

import com.lambdaschool.java.countries.models.Country;
import com.lambdaschool.java.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    private List<Country> findCountry(List<Country> myList, char letter) {
        List<Country> tempList = new ArrayList<>();

        for (Country c : myList) {
            if (c.getName().toLowerCase().charAt(0) == letter) {
                tempList.add(c);
            }
        }
        return tempList;
    }

    @Autowired
    CountryRepository ctrrepos;

    // http://localhost:8087/names/all
    @GetMapping(value = "/names/all", produces = "application/json")
    public ResponseEntity<?> getAllCountries() {
        List<Country> myList = new ArrayList<>();
        ctrrepos.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:8087/names/start/u
    @GetMapping(value = "/names/start/{letter}", produces = "application/json")
    public ResponseEntity<?> getAllCountriesByFirstChar(@PathVariable char letter) {
        System.out.println(letter);
        List<Country> countryList = new ArrayList<>();
        ctrrepos.findAll().iterator().forEachRemaining(countryList::add);
        List<Country> rtnList = findCountry(countryList, letter);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    // http:localhost:8087/population/total
    @GetMapping(value = "/population/total", produces = "application/json")
    public ResponseEntity<?> getTotalPopulation() {
        List<Country> popList = new ArrayList<>();
        ctrrepos.findAll().iterator().forEachRemaining(popList::add);

        long total = 0;
        for (Country c : popList) {
            total += c.getPopulation();
        }

        String outputMsg = "The total population is" + total;

        System.out.println(outputMsg);
        return new ResponseEntity<>(outputMsg, HttpStatus.OK);
    }

    // http:localhost:8087/population/min
    @GetMapping(value = "/population/min", produces = "application/json")
    public ResponseEntity<?> getMinPopulation() {
        List<Country> minList = new ArrayList<>();
        ctrrepos.findAll().iterator().forEachRemaining(minList::add);

        minList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));

        Country min = minList.get(minList.size() - 1);



        return new ResponseEntity<>(min, HttpStatus.OK);
    }

    // http:localhost:8087/population/max
    @GetMapping(value = "/population/max", produces = "application/json")
    public ResponseEntity<?> getMaxPopulation() {
        List<Country> maxList = new ArrayList<>();
        ctrrepos.findAll().iterator().forEachRemaining(maxList::add);
        maxList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(maxList.get(0), HttpStatus.OK);
    }

    // http://localhost:8087/population/median
    @GetMapping(value = "/population/median", produces = "application/json")
    public ResponseEntity<?> getMedPopulation() {
        List<Country> medList = new ArrayList<>();
        ctrrepos.findAll().iterator().forEachRemaining(medList::add);
        medList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(medList.get((medList.size() / 2) - 1), HttpStatus.OK);
    }
}
