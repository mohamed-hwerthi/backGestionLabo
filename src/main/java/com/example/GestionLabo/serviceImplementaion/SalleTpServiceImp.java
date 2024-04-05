package com.example.GestionLabo.serviceImplementaion;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.SalleTp;
import com.example.GestionLabo.repository.LaboRepo;
import com.example.GestionLabo.repository.SalleTpRepo;
import com.example.GestionLabo.requestDto.SalleTpRequestDto;
import com.example.GestionLabo.serviceDeclaration.SalleTpServiceDec;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scala.jdk.OptionConverters;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SalleTpServiceImp implements SalleTpServiceDec {
    private  final SalleTpRepo salleTpRepo ;
    private final LaboRepo laboRepo;
    private final Logger logger = LoggerFactory.getLogger(SalleTpServiceImp.class);
    @Override
    public List<SalleTp> getAllSalleTps() {
        return this.salleTpRepo.findAll()  ;
    }

    @Override
    public SalleTp getSalleTpById(String id) {
        Optional<SalleTp>optionalSalleTp = this.salleTpRepo.findById(id);
        return optionalSalleTp.orElseThrow(()->new CustomNotFoundException("salleTp" , id));
    }

    @Override
    public void deleteSalleTp(String id) {
        if (!salleTpRepo.existsById(id)){
            throw new CustomNotFoundException("salleTp" , id) ;
        }
        salleTpRepo.deleteById(id) ;


    }

    @Override
    public SalleTp saveSalleTp(SalleTpRequestDto salleTpRequestDto) {
        Optional < Labo>optionalLabo=this.laboRepo.findById(salleTpRequestDto.getIdLabo());
        Labo labo = optionalLabo.orElseThrow(()->new CustomNotFoundException("labo" , salleTpRequestDto.getIdLabo())) ;
        SalleTp salleTp = new SalleTp();
        salleTp.setLabo(labo);
        salleTp.setNumero(salleTpRequestDto.getNumero());
     SalleTp savedSalleTp=   this.salleTpRepo.save(salleTp) ;
        labo.getSallesTp().add(savedSalleTp) ;
        this.laboRepo.save(labo) ;
        return savedSalleTp;


    }
}
