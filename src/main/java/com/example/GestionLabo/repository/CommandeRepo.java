package com.example.GestionLabo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommandeRepo extends MongoRepository<CommandeRepo, String> {
}
