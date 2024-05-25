package com.example.GestionLabo.models;


import com.example.GestionLabo.models.enums.NiveauScolaire;
import com.example.GestionLabo.models.enums.TpType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "tp")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Tp {
    @Id
    private  String id  ;
    private String manip  ;
    private TpType type ;
    private Date jourTp ;
    @DBRef
    private SalleTp salleTp ;
    private NiveauScolaire niveauScolaire ;
    @DBRef
    private List<PreparationProduit>preparationProduits  = new ArrayList<>() ;
    @DBRef
    private List<Preparation>preparations = new ArrayList<>() ;
    @DBRef
    private List<Produit>produits = new ArrayList<>() ;
}
