package com.example.GestionLabo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categorie {
    @Id
    private String id;
    private String designation;
    @DBRef
    @JsonIgnore
    private List<Rubrique> rubriques = new ArrayList<>();
    @DBRef
    @JsonIgnore
    private List<Produit> produits = new ArrayList<>();
}
