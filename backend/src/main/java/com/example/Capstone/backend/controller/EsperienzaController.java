package com.example.Capstone.backend.controller;


import com.example.Capstone.backend.dto.EsperienzaDTO;
import com.example.Capstone.backend.exception.NotFoundException;
import com.example.Capstone.backend.model.Esperienza;
import com.example.Capstone.backend.model.LivelloAdrenalina;
import com.example.Capstone.backend.service.CloudinaryService;
import com.example.Capstone.backend.service.EsperienzaService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/esperienze")
public class EsperienzaController {

    @Autowired
    private EsperienzaService esperienzaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Esperienza create(@RequestBody @Valid EsperienzaDTO dto, BindingResult bindingResult) throws NotFoundException {
        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("", String::concat));
        }
        return esperienzaService.create(dto);
    }

    @GetMapping
    public List<Esperienza> getAll(){
        return esperienzaService.getAll();
    }

    @GetMapping("/{id}")
    public Esperienza getById(@PathVariable Long id) throws NotFoundException{
        return esperienzaService.getById(id);
    }

    @PutMapping("/{id}")
    public Esperienza updateEsperienza(@PathVariable Long id, @RequestBody @Valid EsperienzaDTO dto, BindingResult bindingResult) throws NotFoundException{
        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("", String::concat));
        }
        return esperienzaService.updateEsperienza(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws NotFoundException{
        esperienzaService.delete(id);
    }
    @GetMapping("/filtro/localita")
    public List<Esperienza> getByLocalita(@RequestParam String localita) {
        return esperienzaService.getByLocalita(localita);
    }

    @GetMapping("/filtro/categoria")
    public List<Esperienza> getByCategoria(@RequestParam String categoria) {
        return esperienzaService.getByCategoria(categoria);
    }

    @GetMapping("/filtro/livello")
    public List<Esperienza> getByLivello(@RequestParam String livello) throws NotFoundException {
        LivelloAdrenalina livelloEnum = LivelloAdrenalina.valueOf(livello.toUpperCase());
        return esperienzaService.getByLivelloAdrenalina(livelloEnum);
    }

    @GetMapping("/filtro/durata")
    public List<Esperienza> getByDurata(@RequestParam int durataMax) {
        return esperienzaService.getByDurataMax(durataMax);
    }

}
