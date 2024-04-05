package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Tp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TpRepo extends MongoRepository<Tp, String> {
}
