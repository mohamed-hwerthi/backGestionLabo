package com.example.GestionLabo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Document(collection = "inventaire")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  Inventaire {
    @Id
    private  String id  ;
    private  String anneeScolaire ;
    private  String commentaire  ;
    private LocalDateTime date  ;
    private String Responsable  ;
    private List< ProduitInvenatire> produitInvenatires ;


}
