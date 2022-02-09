package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Parceria;
import com.dev.controleGastos.repository.ParceriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParceriaService {

    @Autowired
    private ParceriaRepository repository;

    public void salvar(Parceria parceria){
        repository.save(parceria);
    }

    public List<Parceria> getParcerias(){
        return repository.findAll();
    }
}
