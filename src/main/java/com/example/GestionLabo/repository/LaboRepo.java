package com.example.GestionLabo.repository;


import com.example.GestionLabo.models.Labo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboRepo  extends MongoRepository<Labo , String> {
}
