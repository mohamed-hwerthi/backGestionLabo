package com.example.GestionLabo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Data
@Document(collection = "commande")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {
    @Id
    private  String id  ;
    private String designation ;
    private LocalDate Date ;
    private  String observation   ;
    private Long numero ;
    private List<ProduitCommande>produitCommandes ;
}
