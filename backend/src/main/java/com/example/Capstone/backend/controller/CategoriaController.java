package com.example.Capstone.backend.controller;

import com.example.Capstone.backend.exception.NotFoundException;
import com.example.Capstone.backend.model.Categoria;
import com.example.Capstone.backend.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody @Valid Categoria categoria, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().toString());
        }
        return categoriaService.createCategoria(categoria);
    }


    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.getAllCategorie();
    }


    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) throws NotFoundException {
        return categoriaService.getCategoriaById(id);
    }


    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody @Valid Categoria categoria, BindingResult bindingResult) throws NotFoundException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().toString());
        }
        return categoriaService.updateCategoria(id, categoria);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws NotFoundException {
        categoriaService.deleteCategoria(id);
    }
}
