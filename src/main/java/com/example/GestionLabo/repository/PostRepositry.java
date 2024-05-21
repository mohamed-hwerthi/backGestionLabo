package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositry extends MongoRepository<Posts , String> {
}


