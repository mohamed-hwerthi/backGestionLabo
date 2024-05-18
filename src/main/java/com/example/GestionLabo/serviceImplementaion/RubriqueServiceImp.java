package com.example.GestionLabo.serviceImplementaion;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.models.Rubrique;
import com.example.GestionLabo.repository.CategorieRepo;
import com.example.GestionLabo.repository.RubriqueRepo;
import com.example.GestionLabo.requestDto.RubriqueRequestDto;
import com.example.GestionLabo.serviceDeclaration.RubriqueServiceDec;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RubriqueServiceImp implements RubriqueServiceDec {
    private final RubriqueRepo rubriqueRepo;
    private final CategorieRepo categorieRepo;

    @Override
    public List<Rubrique> getAll() {
        return this.rubriqueRepo.findAll();

    }

    @Override
    public Rubrique getRubriqueById(String id) {
        Optional<Rubrique> optionalRubrique = this.rubriqueRepo.findById(id);
        if (optionalRubrique.isEmpty()) {
            throw new CustomNotFoundException("Rubrique", id);
        } else {
            return optionalRubrique.get();

        }

    }

    @Override
    public void deleteRubrique(String id) {
        if (!rubriqueRepo.existsById(id)) {
            throw new CustomNotFoundException("Rubrique", id);
        }
        rubriqueRepo.deleteById(id);
    }

    @Override
    public Rubrique addRubrique(RubriqueRequestDto rub) {
        Optional<Categorie> categorieOptiobnal = this.categorieRepo.findById(rub.getIdCategorie());
        Categorie categorie = categorieOptiobnal
                .orElseThrow(() -> new CustomNotFoundException("categorie", rub.getIdCategorie()));
        Rubrique rubrique = new Rubrique();
        rubrique.setCategorie(categorie);
        rubrique.setDesignation(rub.getDesignation());
        Rubrique savedRub = this.rubriqueRepo.save(rubrique);
        categorie.getRubriques().add(savedRub);
        this.categorieRepo.save(categorie);
        return savedRub;

    }

}
