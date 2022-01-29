package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Categoria;
import com.dev.controleGastos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public void salvar(Categoria categoria){
        repository.save(categoria);
    }

    public List<Categoria> getCategoria(){
        return repository.findAll();
    }
}
