package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionLabo.models.Fournisseur;

@Repository

public interface FournisseurRepo extends MongoRepository<Fournisseur, String> {
}
