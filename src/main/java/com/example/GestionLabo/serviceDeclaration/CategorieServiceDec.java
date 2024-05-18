package com.example.GestionLabo.serviceDeclaration;

import java.util.List;

import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.requestDto.CategorieRequestDto;

public interface CategorieServiceDec {
    List<Categorie> getAll();

    Categorie getById(String id);

    void delete(String id);

    Categorie addCategorie(String cat);

}
