
package com.example.GestionLabo.serviceImplementaion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.repository.CategorieRepo;
import com.example.GestionLabo.requestDto.CategorieRequestDto;
import com.example.GestionLabo.serviceDeclaration.CategorieServiceDec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieServiceImp implements CategorieServiceDec {
    private final CategorieRepo categorieRepo;

    @Override
    public List<Categorie> getAll() {
        return this.categorieRepo.findAll();
    }

    @Override
    public Categorie getById(String id) {
        Optional<Categorie> categorie = this.categorieRepo.findById(id);
        if (categorie.isEmpty()) {
            throw new CustomNotFoundException("categorie", id);
        } else {
            return categorie.get();
        }

    }

    @Override
    public void delete(String id) {
        if (!categorieRepo.existsById(id)) {
            throw new CustomNotFoundException("categorie", id);
        }
        categorieRepo.deleteById(id);

    }

    @Override
    public Categorie addCategorie(String cat) {
        Categorie categorie = new Categorie();
        categorie.setDesignation(cat);
        return this.categorieRepo.save(categorie);
    }

}
