package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Armoire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmoireRepo extends MongoRepository<Armoire, String> {

}
