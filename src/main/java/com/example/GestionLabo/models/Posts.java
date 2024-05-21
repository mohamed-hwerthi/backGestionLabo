package com.example.GestionLabo.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Posts {
    @Id
    private String id;
    private String title;
    private LocalDate date ;
    private String content;
}
