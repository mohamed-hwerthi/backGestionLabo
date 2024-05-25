package com.example.GestionLabo.requestDto;


import com.example.GestionLabo.models.ProduitCommande;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CommandeRequestDto {
    private String  designation ;
    private LocalDate Date ;
    private  String observation   ;
    private Long numero ;
    private List<ProduitCommande> produitCommandes ;
}

