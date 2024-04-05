package com.example.GestionLabo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.example.GestionLabo.models.Tp;
import com.example.GestionLabo.requestDto.TpRequestDto;
import com.example.GestionLabo.serviceImplementaion.TpServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tp")
@RequiredArgsConstructor
public class TpController {
    private final TpServiceImp tpServiceImp;
    private final Logger logger = LoggerFactory.getLogger(TpController.class);

    @GetMapping("/all")
    public List<Tp> getAllPreparations() {
        return tpServiceImp.getAllPreparations();
    }

    @GetMapping("/one/{id}")

    public Tp getTpById(@PathVariable() String id) {
        return tpServiceImp.getTpById(id);
    }

    @PostMapping("")

    public Tp saveTp(@RequestBody() TpRequestDto tp) {
        logger.info(String.valueOf(tp));
        return tpServiceImp.saveTp(tp);
    }

    @DeleteMapping("/{id}")

    public void deleteTp(@PathVariable() String id) {
        tpServiceImp.deleteTp(id);
    }

}
