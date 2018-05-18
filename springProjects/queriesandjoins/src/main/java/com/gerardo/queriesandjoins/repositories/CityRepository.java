package com.gerardo.queriesandjoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.queriesandjoins.models.City;

@Repository
public interface CityRepository extends CrudRepository <City, Long>{

}
