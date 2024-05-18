package com.example.GestionLabo.requestDto;
import lombok.Data;

import java.time.LocalDate;

import java.util.List;


@Data
public class PreparationRequestDto {
    private  String designation  ;
    private LocalDate date  ;
    private List<PreparationReqProduit> preparationReqProduits  ;


}
