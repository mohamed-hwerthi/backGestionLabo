package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionLabo.models.SalleTp;

@Repository
public interface SalleTpRepo extends MongoRepository<SalleTp, String> {
}
