package com.example.GestionLabo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import com.example.GestionLabo.models.Categorie;
import com.example.GestionLabo.requestDto.CategorieRequestDto;
import com.example.GestionLabo.serviceImplementaion.CategorieServiceImp;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("Categorie")

public class CategorieController {
    private final CategorieServiceImp categorieServiceImp;

    @GetExchange("/all")

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

    public ResponseEntity<Categorie> addCategorie(CategorieRequestDto cat) {
        Categorie categorie = categorieServiceImp.addCategorie(cat);
        return ResponseEntity.ok(categorie);
    }

}
