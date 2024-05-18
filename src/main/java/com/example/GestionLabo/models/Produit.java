package com.example.GestionLabo.models;

import com.example.GestionLabo.models.enums.ProduitType;
import com.example.GestionLabo.models.enums.UniteMesure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "produit")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produit {
    @Id
    private String id;
    private String designation;
    private String reference;
    private ProduitType type;
    private int quantiteInitiale;
    @DBRef
    private Categorie categorie;
    @DBRef
    @JsonIgnore
    private Fournisseur fournisseur;
    private UniteMesure uniteMesure;
    @DBRef
    @JsonIgnore
    private Rubrique rubrique;
    @DBRef
    @JsonIgnore
    private Armoire armoire;

}
