
package com.example.GestionLabo.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.GestionLabo.models.Armoire;
import com.example.GestionLabo.requestDto.ArmoireRequestDto;
import com.example.GestionLabo.serviceImplementaion.ArmorieServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Armoire")
@RequiredArgsConstructor
@Slf4j
public class ArmoireController {

    private  final ArmorieServiceImp armorieServiceImp;

    @GetMapping("")
    public  ResponseEntity< List<Armoire>> getAllArmoires() {
        List<Armoire>allArms=  armorieServiceImp.getAllArmoires();
        return  ResponseEntity.ok(allArms);
    }

    @GetMapping("/one/{id}")

    public ResponseEntity<Armoire> getArmoireById(@PathVariable String id) {
         Armoire arm=armorieServiceImp.getArmoireById(id);
        return ResponseEntity.ok(arm) ;
    }

    @PostMapping("")

    public Armoire saveArmoire(@RequestBody() ArmoireRequestDto armoireRequestDto) {
        return armorieServiceImp.saveArmoire(armoireRequestDto);
    }

    @DeleteMapping("{id}")

    public void deleteArmoire(@PathVariable String id) {
        armorieServiceImp.deleteArmoire(id);
    }

}
