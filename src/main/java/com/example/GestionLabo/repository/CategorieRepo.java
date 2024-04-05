package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Categorie;
import jdk.jfr.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieRepo extends MongoRepository<Categorie , String> {
}
