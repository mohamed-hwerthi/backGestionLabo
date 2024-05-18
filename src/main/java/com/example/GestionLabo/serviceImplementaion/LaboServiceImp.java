package com.example.GestionLabo.serviceImplementaion;

import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Labo;
import com.example.GestionLabo.models.enums.LaboType;
import com.example.GestionLabo.repository.LaboRepo;
import com.example.GestionLabo.serviceDeclaration.LaboServiceDec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j


public class LaboServiceImp implements LaboServiceDec {

    private final LaboRepo laboRepo  ;


@Override
    public   List<Labo>getAllLAbo(){
    return this.laboRepo.findAll() ;
    }

    @Override
    public Labo getLaboById(String id) {
             Optional<Labo >labo= laboRepo.findById(id);
             if(labo.isEmpty()){
                 throw new CustomNotFoundException("labo" , id) ;
             }
             else{
                 return labo.get() ;
             }
    }

    @Override
    public void deleteLabo(String id) {
        this.laboRepo.deleteById(id);
    }

    @Override
    public Labo saveLabo(LaboType laboType) {
        Labo labo = new Labo();
         labo.setLaboType(laboType) ;
        return this.laboRepo.save(labo);
    }





}
