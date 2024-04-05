package com.example.GestionLabo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection ="salletp")
@AllArgsConstructor
@NoArgsConstructor
public class SalleTp {
    @Id
    private String id;
    private String Numero;
    @JsonIgnore
    @DBRef
    private Labo labo  ;
    @DBRef
    private List<Armoire>armoires = new ArrayList<>();
}