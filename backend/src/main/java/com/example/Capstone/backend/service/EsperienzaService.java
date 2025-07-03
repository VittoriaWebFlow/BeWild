package com.example.Capstone.backend.service;

import com.example.Capstone.backend.dto.EsperienzaDTO;
import com.example.Capstone.backend.exception.NotFoundException;
import com.example.Capstone.backend.model.Categoria;
import com.example.Capstone.backend.model.Esperienza;
import com.example.Capstone.backend.model.LivelloAdrenalina;
import com.example.Capstone.backend.repository.CategoriaRepository;
import com.example.Capstone.backend.repository.EsperienzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsperienzaService {

    @Autowired
    private EsperienzaRepository esperienzaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Esperienza create(EsperienzaDTO dto) throws NotFoundException{
        Categoria categoria= categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("La categoria non è stata trovata"));

        Esperienza esperienza = new Esperienza();
        esperienza.setTitolo(dto.getTitolo());
        esperienza.setDescrizione(dto.getDescrizione());
        esperienza.setLocalita(dto.getLocalita());
        esperienza.setLivelloAdrenalina(dto.getLivelloAdrenalina());
        esperienza.setDurata(dto.getDurata());
        esperienza.setPrezzo(dto.getPrezzo());
        esperienza.setImmagine(dto.getImmagine());
        esperienza.setCategoria(categoria);

        return esperienzaRepository.save(esperienza);
    }

    //Mi serve per mostrare tutte le mie esperienze
    public List<Esperienza> getAll(){
        return esperienzaRepository.findAll();
    }


    public Esperienza getById(Long id) throws NotFoundException{
        return esperienzaRepository.findById(id).
                orElseThrow(()-> new NotFoundException("L'espereinza con ID" + id + "non è stata trovata"));

    }

    public void delete(Long id) throws NotFoundException{
        Esperienza esperienza= getById(id);
        esperienzaRepository.delete(esperienza);
    }

    public Esperienza updateEsperienza(Long id, EsperienzaDTO dto) throws NotFoundException{
        Esperienza esperienza= getById(id);
        Categoria categoria= categoriaRepository.findById(dto.getCategoriaId()).
                orElseThrow(() -> new NotFoundException("La categoria non è stata trovata"));

        esperienza.setTitolo(dto.getTitolo());
        esperienza.setDescrizione(dto.getDescrizione());
        esperienza.setLocalita(dto.getLocalita());
        esperienza.setLivelloAdrenalina(dto.getLivelloAdrenalina());
        esperienza.setDurata(dto.getDurata());
        esperienza.setPrezzo(dto.getPrezzo());
        esperienza.setImmagine(dto.getImmagine());
        esperienza.setCategoria(categoria);

        return esperienzaRepository.save(esperienza);
    }
    public List<Esperienza> getByLocalita(String localita) {
        return esperienzaRepository.findByLocalitaIgnoreCase(localita);
    }


    public List<Esperienza> getByCategoria(String categoria) {
        return esperienzaRepository.findByCategoria_NomeIgnoreCase(categoria);
    }


    public List<Esperienza> getByLivelloAdrenalina(LivelloAdrenalina livello) throws NotFoundException {
        return esperienzaRepository.findByLivelloAdrenalina(livello);
    }


    public List<Esperienza> getByDurataMax(int durataMax) {
        return esperienzaRepository.findByDurataLessThanEqual(durataMax);
    }
}
