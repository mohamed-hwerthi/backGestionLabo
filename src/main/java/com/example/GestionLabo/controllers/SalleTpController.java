package com.example.GestionLabo.controllers;


import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.requestDto.SalleTpRequestDto;
import com.example.GestionLabo.serviceDeclaration.SalleTpServiceDec;
import com.example.GestionLabo.serviceImplementaion.SalleTpServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("SalleTp")
public class SalleTpController {
    private  final SalleTpServiceImp salleTpServiceImp ;
    @GetMapping("")

    public List<SalleTp> getAllSalleTps() {
        return salleTpServiceImp.getAllSalleTps();
    }
    @GetMapping("/one/{id}")

    public SalleTp getSalleTpById(@PathVariable String id) {
        return salleTpServiceImp.getSalleTpById(id);
    }
    @DeleteMapping("{id}")

    public void deleteSalleTp(@PathVariable String id) {
        salleTpServiceImp.deleteSalleTp(id);
    }
    @PostMapping("")

    public SalleTp saveSalleTp(  @RequestBody SalleTpRequestDto salleTpRequestDto) {
        return salleTpServiceImp.saveSalleTp(salleTpRequestDto);
    }
}
