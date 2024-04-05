package com.example.GestionLabo.serviceDeclaration;

import java.util.List;

import com.example.GestionLabo.models.Rubrique;
import com.example.GestionLabo.requestDto.RubriqueRequestDto;

public interface RubriqueServiceDec {
    List<Rubrique> getAll();

    Rubrique getRubriqueById(String id);

    void deleteRubrique(String id);

    Rubrique addRubrique(RubriqueRequestDto rub);

}
