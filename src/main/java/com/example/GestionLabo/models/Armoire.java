package com.example.GestionLabo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Armoire")
@AllArgsConstructor
@NoArgsConstructor
public class Armoire {
    @Id
    private String id;
    private String designation;
    @DBRef
    @JsonIgnore
    private SalleTp salleTp;
    @DBRef
    private List<Produit> produits = new ArrayList<>();
}
