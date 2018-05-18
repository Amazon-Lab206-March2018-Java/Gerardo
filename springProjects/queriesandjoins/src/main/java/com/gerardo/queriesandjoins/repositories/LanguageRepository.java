package com.gerardo.queriesandjoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.queriesandjoins.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository <Language, Long>{

}
