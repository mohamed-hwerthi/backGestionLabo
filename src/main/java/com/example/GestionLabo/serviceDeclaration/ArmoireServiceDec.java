package com.example.GestionLabo.serviceDeclaration;

import java.util.List;

import com.example.GestionLabo.models.Armoire;
import com.example.GestionLabo.requestDto.ArmoireRequestDto;

public interface ArmoireServiceDec {
    List<Armoire> getAllArmoires();

    Armoire getArmoireById(String id);

    Armoire saveArmoire(ArmoireRequestDto armoire);

    void deleteArmoire(String id);

}
