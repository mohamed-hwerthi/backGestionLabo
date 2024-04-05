package com.example.GestionLabo.models;

import com.example.GestionLabo.models.enums.LaboType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private List<SalleTp>sallesTp = new ArrayList<SalleTp>();
}
