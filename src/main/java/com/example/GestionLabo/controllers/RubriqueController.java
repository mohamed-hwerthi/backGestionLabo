package com.example.GestionLabo.controllers;

import java.util.List;

import com.example.GestionLabo.serviceImplementaion.RubriqueServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionLabo.models.Rubrique;
import com.example.GestionLabo.requestDto.RubriqueRequestDto;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Rubrique")
@RequiredArgsConstructor
public class RubriqueController {
    private final RubriqueServiceImp rubriqueServiceImp;

    @GetMapping("")

    public List<Rubrique> getAll() {
        return rubriqueServiceImp.getAll();
    }

    @GetMapping("/one/{id}")
    public Rubrique getRubriqueById(@PathVariable() String id) {
        return rubriqueServiceImp.getRubriqueById(id);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteRubrique(@PathVariable("id") String id) {
        rubriqueServiceImp.deleteRubrique(id);
        return ResponseEntity.ok("Rubrique deleted");
    }

    @PostMapping("")

    public ResponseEntity<Rubrique> addRubrique(@RequestBody() RubriqueRequestDto rub) {
        Rubrique response = rubriqueServiceImp.addRubrique(rub);
        return ResponseEntity.ok(response);

    }

}
