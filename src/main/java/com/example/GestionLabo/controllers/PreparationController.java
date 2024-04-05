package com.example.GestionLabo.controllers;

import java.util.List;

import com.example.GestionLabo.requestDto.PreparationRequestDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionLabo.models.Preparation;
import com.example.GestionLabo.serviceImplementaion.PreparationServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("preparation")
@RequiredArgsConstructor
public class PreparationController {
    private final PreparationServiceImp preparationServiceImp;

    @GetMapping("/all")

    public List<Preparation> getAllPreparations() {
        return preparationServiceImp.getAllPreparations();
    }

    @GetMapping("/one/{id}")
    public Preparation getPreparationById(@PathVariable() String id) {
        return preparationServiceImp.getPreparationById(id);
    }

    @PostMapping("")

    public Preparation savePreparation(@RequestBody() PreparationRequestDto preparation) {
        return preparationServiceImp.savePreparation(preparation);
    }

    @DeleteMapping("{id}")

    public void deletePeparation(@PathVariable() String id) {
        preparationServiceImp.deletePeparation(id);

    }


}
