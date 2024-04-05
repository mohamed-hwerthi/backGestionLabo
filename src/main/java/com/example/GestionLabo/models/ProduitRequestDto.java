package com.example.GestionLabo.models;

import com.example.GestionLabo.models.enums.ProduitType;
import com.example.GestionLabo.models.enums.UniteMesure;

import lombok.Data;

@Data
public class ProduitRequestDto {
    private String designation;
    private String reference;
    private ProduitType type;
    private int quantiteInitiale;
    private String idCategorie;
    private String idRubrique;
    private String idFournisseur;
    private String idArmoire;
    private UniteMesure uniteMesure;

}
