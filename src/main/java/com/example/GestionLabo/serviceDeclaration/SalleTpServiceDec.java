package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.requestDto.SalleTpRequestDto;

import java.util.List;

public interface SalleTpServiceDec {

    List <SalleTp>getAllSalleTps() ;

    SalleTp getSalleTpById(String id) ;
    void deleteSalleTp(String id) ;
    SalleTp saveSalleTp(SalleTpRequestDto salleTpRequestDto) ;
}
