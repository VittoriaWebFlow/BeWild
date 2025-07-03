package com.example.Capstone.backend.repository;

import com.example.Capstone.backend.model.Esperienza;
import com.example.Capstone.backend.model.LivelloAdrenalina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EsperienzaRepository extends JpaRepository<Esperienza, Long> {
    List<Esperienza>findByLocalitaIgnoreCase(String localita);
    List<Esperienza> findByCategoria_NomeIgnoreCase(String categoria);
    List<Esperienza> findByLivelloAdrenalina(LivelloAdrenalina livello);
    List<Esperienza> findByDurataLessThanEqual(int durata);
}
