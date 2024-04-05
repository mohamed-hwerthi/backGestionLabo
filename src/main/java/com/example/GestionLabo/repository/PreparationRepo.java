package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionLabo.models.Preparation;

@Repository

public interface PreparationRepo extends MongoRepository<Preparation, String> {
}
