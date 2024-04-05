package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionLabo.models.Inventaire;

@Repository

public interface InventaireRepo extends MongoRepository<Inventaire, String> {
}
