package com.example.GestionLabo.controllers;

import java.util.List;

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
import com.example.GestionLabo.serviceImplementaion.RubriquerServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rubrique")
@RequiredArgsConstructor
public class RubriqueController {
    private final RubriquerServiceImp rubriquerServiceImp;

    @GetMapping("/all")

    public List<Rubrique> getAll() {
        return rubriquerServiceImp.getAll();
    }

    @GetMapping("/one/{id}")
    public Rubrique getRubriqueById(@PathVariable() String id) {
        return rubriquerServiceImp.getRubriqueById(id);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteRubrique(@PathVariable("id") String id) {
        rubriquerServiceImp.deleteRubrique(id);
        return ResponseEntity.ok("Rubrique deleted");
    }

    @PostMapping("")

    public ResponseEntity<Rubrique> addRubrique(@RequestBody() RubriqueRequestDto rub) {
        Rubrique response = rubriquerServiceImp.addRubrique(rub);
        return ResponseEntity.ok(response);

    }

}
