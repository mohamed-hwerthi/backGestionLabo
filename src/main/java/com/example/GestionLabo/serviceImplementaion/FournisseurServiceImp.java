package com.example.GestionLabo.serviceImplementaion;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Fournisseur;
import com.example.GestionLabo.repository.FournisseurRepo;
import com.example.GestionLabo.requestDto.FournisseurRequestDto;
import com.example.GestionLabo.serviceDeclaration.FournisseurServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FournisseurServiceImp implements FournisseurServiceDec {
    private final FournisseurRepo fournisseurRepo ;

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return this.fournisseurRepo.findAll() ;

    }

    @Override
    public Fournisseur getFournisseurById(String id) {
        Optional<Fournisseur>optionalFournisseur = this.fournisseurRepo.findById(id);
        return optionalFournisseur.orElseThrow(() -> new CustomNotFoundException("fournisseur", id));
    }

    @Override
    public void deleteFournisseur(String id) {
        if (!this.fournisseurRepo.existsById(id)) {
            throw new CustomNotFoundException("fournisseur", id);
        }
        this.fournisseurRepo.deleteById(id);

    }

    @Override
    public Fournisseur saveFournisseur(FournisseurRequestDto fournisseurRequestDto) {
        Fournisseur fournisseur = Fournisseur
                .builder()
                .nom(fournisseurRequestDto.getNom())
                .adresse(fournisseurRequestDto.getAdresse())
                .email(fournisseurRequestDto.getEmail())
                .nmrTel(fournisseurRequestDto.getNmrTel())
                .build();
      return   this.fournisseurRepo.save(fournisseur);

    }
}
