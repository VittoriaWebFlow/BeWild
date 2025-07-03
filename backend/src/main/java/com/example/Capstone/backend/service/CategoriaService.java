package com.example.Capstone.backend.service;


import com.example.Capstone.backend.exception.NotFoundException;
import com.example.Capstone.backend.model.Categoria;
import com.example.Capstone.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> getAllCategorie(){
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id)throws NotFoundException{
        return categoriaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("La categoria con ID" + id + "non è stata trovata"));

    }

    public void deleteCategoria(Long id)throws NotFoundException{
        Categoria categoria= getCategoriaById(id);
        categoriaRepository.delete(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoriaAggiornata) throws NotFoundException {
        Categoria categoria = getCategoriaById(id);
        categoria.setNome(categoriaAggiornata.getNome());
        return categoriaRepository.save(categoria);
    }
}
