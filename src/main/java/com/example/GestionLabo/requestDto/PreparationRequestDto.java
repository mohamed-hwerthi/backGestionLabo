package com.example.GestionLabo.requestDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class PreparationRequestDto {
    private  String designation  ;
    private LocalDateTime date  ;
    private List<PreparationReqProduit> preparationReqProduits  ;


}
