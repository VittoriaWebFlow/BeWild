package com.example.Capstone.backend.service;


import com.example.Capstone.backend.model.Recensione;
import com.example.Capstone.backend.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecensioneService {

    private final RecensioneRepository recensioneRepo;

    public RecensioneService(RecensioneRepository recensioneRepo){
        this.recensioneRepo = recensioneRepo;
    }

    public Recensione create(Recensione recensione){
        return recensioneRepo.save(recensione);
    }

    public List<Recensione> getByEsperienzaId(Long esperienzaId){
        return recensioneRepo.findByEsperienzaId(esperienzaId);
    }
}
