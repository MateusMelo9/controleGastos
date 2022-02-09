package com.dev.controleGastos.service;

import com.dev.controleGastos.model.CategoriaLancamento;
import com.dev.controleGastos.model.TipoCategoria;
import com.dev.controleGastos.repository.TipoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCategoriaService {

    @Autowired
    private TipoCategoriaRepository repository;

    public void salvar(TipoCategoria tipoCategoria){
        repository.save(tipoCategoria);
    }

    public List<TipoCategoria> getTipoCategoria(){
        return repository.findAll();
    }
}
