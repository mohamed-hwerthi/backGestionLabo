package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionLabo.models.Produit;

@Repository

public interface ProduitRepo extends MongoRepository<Produit, String> {

}
