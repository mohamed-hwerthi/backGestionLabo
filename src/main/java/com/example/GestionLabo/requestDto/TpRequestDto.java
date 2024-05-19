package com.example.GestionLabo.requestDto;

import java.time.LocalDateTime;

import com.example.GestionLabo.models.enums.NiveauScolaire;
import com.example.GestionLabo.models.enums.TpType;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class TpRequestDto {
    private String manip ;
    private TpType tpType;
    private LocalDateTime jourTp;
    private String idProf;
    private String idSalleTp;
    private NiveauScolaire niveauScolaire;
    private List<String> idsPrepararation = new ArrayList<>();
    private List<String> idsProduit = new ArrayList<>();

}
