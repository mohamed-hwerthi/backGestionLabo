package com.example.GestionLabo.repository;


import com.example.GestionLabo.models.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public   interface CommandeRep extends MongoRepository<Commande , String> {

}
