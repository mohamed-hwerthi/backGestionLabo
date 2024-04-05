package com.example.GestionLabo.models;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "fournisseur")
@Builder
public class Fournisseur {
    @Id
    private String id  ;
    private String nom  ;
    private  String adresse ;
    private  String email  ;
    private    String nmrTel ;

}
