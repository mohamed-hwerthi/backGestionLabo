package com.example.GestionLabo.serviceDeclaration;

import java.util.List;

import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.requestDto.PreparationRequestDto;

public interface PreparationServiceDec {
    List<Preparation> getAllPreparations();

    Preparation getPreparationById(String id);

    Preparation savePreparation(PreparationRequestDto preparation);

    void deletePeparation(String id);

}
