package com.example.GestionLabo.models;

import com.example.GestionLabo.models.enums.LaboType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "labo")
@AllArgsConstructor
@NoArgsConstructor
public class Labo {
    @Id
    private String id   ;
    private LaboType laboType  ;
    @DBRef
    @JsonIgnore
    private List<SalleTp>sallesTp = new ArrayList<SalleTp>();
}