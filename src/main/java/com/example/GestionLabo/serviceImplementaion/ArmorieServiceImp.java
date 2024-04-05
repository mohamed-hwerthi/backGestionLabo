package com.example.GestionLabo.serviceImplementaion;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Armoire;
import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.repository.ArmoireRepo;
import com.example.GestionLabo.repository.SalleTpRepo;
import com.example.GestionLabo.requestDto.ArmoireRequestDto;
import com.example.GestionLabo.serviceDeclaration.ArmoireServiceDec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ArmorieServiceImp implements ArmoireServiceDec {
    private final ArmoireRepo armoireRepo;
    private final SalleTpRepo salleTpRepo;
    private final Logger logger = LoggerFactory.getLogger(ArmorieServiceImp.class);

    @Override
    public List<Armoire> getAllArmoires() {
        return this.armoireRepo.findAll();

    }

    @Override
    public Armoire getArmoireById(String id) {
        Optional<Armoire> optionalArmoire = this.armoireRepo.findById(id);
        if (optionalArmoire.isEmpty()) {
            throw new CustomNotFoundException("Armoire", id);
        } else {
            return optionalArmoire.get();

        }
    }

    @Override
    public Armoire saveArmoire(ArmoireRequestDto armoireRequestDto) {
        logger.info(armoireRequestDto.getIdSalleTp());

        Optional<SalleTp> salleTpOptiobnal = this.salleTpRepo.findById(armoireRequestDto.getIdSalleTp());
        SalleTp salleTp = salleTpOptiobnal
                .orElseThrow(() -> new CustomNotFoundException("salleTp", armoireRequestDto.getIdSalleTp()));
        logger.info("testing");
        Armoire arm = new Armoire();
        logger.info("arm");
        logger.info(armoireRequestDto.getIdSalleTp());
        arm.setSalleTp(salleTp);
        arm.setDesignation(armoireRequestDto.getDesignation());
        Armoire savedArm = this.armoireRepo.save(arm);
        salleTp.getArmoires().add(savedArm);
        this.salleTpRepo.save(salleTp);
        return savedArm;

    }

    @Override
    public void deleteArmoire(String id) {
        if (!armoireRepo.existsById(id)) {
            throw new CustomNotFoundException("armoire", id);
        }
        armoireRepo.deleteById(id);
    }

}
