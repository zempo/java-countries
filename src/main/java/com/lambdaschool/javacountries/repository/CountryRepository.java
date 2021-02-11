package com.lambdaschool.javacountries.repository;

import com.lambdaschool.javacountries.models.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * CountryRepository
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
}
