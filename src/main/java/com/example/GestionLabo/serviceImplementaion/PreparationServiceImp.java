package com.example.GestionLabo.serviceImplementaion;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.GestionLabo.models.PreparationProduit;
import com.example.GestionLabo.requestDto.PreparationRequestDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.repository.PreparationRepo;
import com.example.GestionLabo.serviceDeclaration.PreparationServiceDec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreparationServiceImp implements PreparationServiceDec {
    private final PreparationRepo preparationRepo;
    private final Logger log = LoggerFactory.getLogger(PreparationServiceImp.class);
    private final ModelMapper modelMapper;

    @Override
    public List<Preparation> getAllPreparations() {
        return this.preparationRepo.findAll();

    }

    @Override
    public Preparation getPreparationById(String id) {
        Optional<Preparation> preparation = this.preparationRepo.findById(id);
        if (preparation.isEmpty()) {
            throw new CustomNotFoundException("preparation", id);
        } else {
            return preparation.get();
        }
    }

    @Override
    public Preparation savePreparation(PreparationRequestDto prep) {
        Preparation preparation = new Preparation();
        List<PreparationProduit> preparationProduits = prep.getPreparationReqProduits()
                .stream()
                .map(element -> modelMapper.map(element, PreparationProduit.class))
                .collect(Collectors.toList());
        preparation.setPreparationProduits(preparationProduits);
        preparation.setDate(prep.getDate());
        preparation.setDesignation(prep.getDesignation());
        return preparationRepo.save(preparation);
    }

    @Override
    public void deletePeparation(String id) {
        this.preparationRepo.deleteById(id);
    }

}
