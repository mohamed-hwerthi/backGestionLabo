package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionLabo.models.Rubrique;

@Repository

public interface RubriqueRepo extends MongoRepository<Rubrique, String> {

}
