package com.example.GestionLabo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.requestDto.CategorieRequestDto;
import com.example.GestionLabo.serviceImplementaion.CategorieServiceImp;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("Categorie")
@Slf4j

public class CategorieController {
    private final CategorieServiceImp categorieServiceImp;

    @GetMapping("")

    public List<Categorie> getAll() {
        return categorieServiceImp.getAll();
    }

    @GetMapping("/one/{id}")
    public Categorie getById(@PathVariable() String id) {
        return categorieServiceImp.getById(id);
    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable() String id) {
        categorieServiceImp.delete(id);
    }

    @PostMapping("")

    public ResponseEntity<Categorie> addCategorie(  @RequestBody String  cat) {
        log.info(cat);
        Categorie categorie = categorieServiceImp.addCategorie(cat);
        return ResponseEntity.ok(categorie);
    }

}
