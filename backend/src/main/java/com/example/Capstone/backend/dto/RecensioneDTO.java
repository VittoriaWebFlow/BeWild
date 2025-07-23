package com.example.Capstone.backend.dto;

import lombok.Data;

@Data
public class RecensioneDTO {
    private String autore;
    private String contenuto;
    private int voto;
    private Long esperienzaId;
}