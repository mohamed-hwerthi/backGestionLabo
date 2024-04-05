package com.example.GestionLabo.serviceDeclaration;

import java.util.List;

import com.example.GestionLabo.models.Tp;
import com.example.GestionLabo.requestDto.TpRequestDto;

public interface TpServiceDec {
    List<Tp> getAllPreparations();

    Tp getTpById(String id);

    Tp saveTp(TpRequestDto tp);

    void deleteTp(String id);

}
