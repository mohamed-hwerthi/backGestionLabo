package com.example.GestionLabo.controllers;

import com.example.GestionLabo.models.Fournisseur;
import com.example.GestionLabo.requestDto.FournisseurRequestDto;
import com.example.GestionLabo.serviceImplementaion.FournisseurServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
@RequiredArgsConstructor

public class FournisseurController {
    private final FournisseurServiceImp fournisseurServiceImp ;
    @GetMapping("")

    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurServiceImp.getAllFournisseurs();
    }
    @GetMapping("/one/{id}")

    public Fournisseur getFournisseurById(  @PathVariable() String id) {
        return fournisseurServiceImp.getFournisseurById(id);
    }
    @DeleteMapping("{id}")

    public void deleteFournisseur( @PathVariable String id) {
        fournisseurServiceImp.deleteFournisseur(id);
    }
    @PostMapping("")

    public Fournisseur saveFournisseur( @RequestBody() FournisseurRequestDto fournisseurRequestDto) {
        return fournisseurServiceImp.saveFournisseur(fournisseurRequestDto);
    }
}
