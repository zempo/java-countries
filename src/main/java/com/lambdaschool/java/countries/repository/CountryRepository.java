package com.lambdaschool.java.countries.repository;

import com.lambdaschool.java.countries.models.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * CountryRepository
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
}
