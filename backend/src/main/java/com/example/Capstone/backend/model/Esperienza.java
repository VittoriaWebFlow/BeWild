package com.example.Capstone.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Esperienza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titolo;
    private String descrizione;
    @Column(columnDefinition = "TEXT")
    private String descrizioneEstesa;
    private String localita;
    private String livelloAdrenalina;
    private int durata;
    private double prezzo;
    private String immagine;

    @ManyToOne
    private Categoria categoria;

}
