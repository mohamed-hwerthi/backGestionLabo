package com.example.GestionLabo.controllers;


import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.enums.LaboType;
import com.example.GestionLabo.serviceImplementaion.LaboServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Labo")
public class LaboController {
    private  final LaboServiceImp laboServiceImp ;



    @GetMapping("")
    public List<Labo> getAllLAbo() {
        return laboServiceImp.getAllLAbo();
    }
@GetMapping("/one/{id}")
    public Labo getLaboById(@PathVariable String id) {
        return laboServiceImp.getLaboById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteLabo(@PathVariable  String id) {
        laboServiceImp.deleteLabo(id);
    }
@PostMapping("")
    public Labo saveLabo(   @RequestBody LaboType laboType) {
        return laboServiceImp.saveLabo(laboType);
    }
}
