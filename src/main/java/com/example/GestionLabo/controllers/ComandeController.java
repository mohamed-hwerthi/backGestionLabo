package com.example.GestionLabo.controllers;


import com.example.GestionLabo.models.Commande;
import com.example.GestionLabo.requestDto.CommandeRequestDto;
import com.example.GestionLabo.serviceImplementaion.CommandeServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commande")
@RequiredArgsConstructor
public class ComandeController {
    private final CommandeServiceImp commandeServiceImp ;
@GetMapping("")
public List<Commande> getAllCommandes() {
        return commandeServiceImp.getAllCommandes();
    }
    @DeleteMapping("{id}")

    public void deleteCommmande(  @PathVariable("id") String idCommande) {
        commandeServiceImp.deleteCommmande(idCommande);
    }
@PostMapping("")
    public Commande saveCommande(   @RequestBody CommandeRequestDto commandeRequestDto) {
        return commandeServiceImp.saveCommande(commandeRequestDto);
    }
}
