package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Commande;
import com.example.GestionLabo.requestDto.CommandeRequestDto;

import java.util.List;

public interface CommadeServiceDec {
    List <Commande > getAllCommandes() ;
    void deleteCommmande( String idCommande) ;
    Commande  saveCommande(CommandeRequestDto commandeRequestDto) ;
}
