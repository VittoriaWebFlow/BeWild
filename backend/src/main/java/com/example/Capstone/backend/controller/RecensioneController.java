package com.example.Capstone.backend.controller;


import com.example.Capstone.backend.dto.RecensioneDTO;
import com.example.Capstone.backend.exception.NotFoundException;
import com.example.Capstone.backend.model.Recensione;
import com.example.Capstone.backend.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recensioni")
@CrossOrigin
public class RecensioneController {


    private RecensioneService recensioneService;

    public RecensioneController(RecensioneService recensioneService){
        this.recensioneService= recensioneService;
    }

    @PostMapping
    public Recensione create(@RequestBody RecensioneDTO dto) throws NotFoundException {
        return recensioneService.create(dto);
    }

    @GetMapping("/esperienza/{esperienzaId}")
    public List<Recensione> getByEsperienza(@PathVariable Long esperienzaId){
        return recensioneService.getByEsperienzaId(esperienzaId);
    }
}
