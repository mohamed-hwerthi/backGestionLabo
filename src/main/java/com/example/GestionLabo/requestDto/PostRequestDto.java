package com.example.GestionLabo.requestDto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class PostRequestDto {
    private String title;
    private LocalDate date ;
    private String content;
}
