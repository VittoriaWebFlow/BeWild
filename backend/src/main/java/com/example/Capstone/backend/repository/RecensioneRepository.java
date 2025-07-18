package com.example.Capstone.backend.repository;

import com.example.Capstone.backend.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByEsperienzaId(Long esperienzaId);
}
