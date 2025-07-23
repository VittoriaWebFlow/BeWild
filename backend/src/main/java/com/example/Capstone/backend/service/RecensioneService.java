package com.example.Capstone.backend.service;


import com.example.Capstone.backend.exception.NotFoundException;
import com.example.Capstone.backend.model.Recensione;
import com.example.Capstone.backend.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Capstone.backend.dto.RecensioneDTO;
import com.example.Capstone.backend.model.Esperienza;


import java.util.List;

@Service
public class RecensioneService {

    @Autowired
    private EsperienzaService esperienzaService;


    private final RecensioneRepository recensioneRepo;

    public RecensioneService(RecensioneRepository recensioneRepo){
        this.recensioneRepo = recensioneRepo;
    }

    public Recensione create(RecensioneDTO dto) throws NotFoundException {
        Recensione recensione = new Recensione();
        recensione.setAutore(dto.getAutore());
        recensione.setContenuto(dto.getContenuto());
        recensione.setVoto(dto.getVoto());

        Esperienza esperienza = esperienzaService.getById(dto.getEsperienzaId());
        recensione.setEsperienza(esperienza);

        return recensioneRepo.save(recensione);
    }


    public List<Recensione> getByEsperienzaId(Long esperienzaId){
        return recensioneRepo.findByEsperienzaId(esperienzaId);
    }
}
