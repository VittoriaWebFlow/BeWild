package com.example.Capstone.backend.dto;


import com.example.Capstone.backend.model.Categoria;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EsperienzaDTO {

    private Long id;

    @NotBlank(message = "Il titolo dell'esperienza è obbligatorio")
    private String titolo;
    @NotBlank(message = "La descrizione è obbligatoria")
    private String descrizione;
    private String descrizioneEstesa;
    @NotBlank(message = "La località è obbligatoria")
    private String localita;
    @NotBlank(message = "Il livello di adrenalina è obbligatoria")
    private String livelloAdrenalina;
    @Min(value = 1, message = "La durata dell'esperienza dev'essere almeno di un'ora!")
    private int durata;
    @DecimalMin(value = "0.0", inclusive = false,message = "il prezzo dell'esperienza dev'essere positivo")
    private double prezzo;
    private String immagine;

    @NotNull(message = "La categoria è obbligatoria")
    private Long categoriaId;
}
