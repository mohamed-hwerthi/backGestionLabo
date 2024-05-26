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
@Document(collection = "preparation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Preparation {
    @Id
    private  String id  ;
    private  String designation  ;
    private  String quantiteEau  ;
    private LocalDate date  ;
    private  List<PreparationProduit>preparationProduits ;


}
