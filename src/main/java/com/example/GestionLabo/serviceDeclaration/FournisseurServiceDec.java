package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Fournisseur;
import com.example.GestionLabo.requestDto.FournisseurRequestDto;


import java.util.List;



public interface FournisseurServiceDec {
    List<Fournisseur>getAllFournisseurs() ;
    Fournisseur getFournisseurById(String id) ;
    void deleteFournisseur(String id) ;
    Fournisseur saveFournisseur(FournisseurRequestDto fournisseurRequestDto) ;
}
