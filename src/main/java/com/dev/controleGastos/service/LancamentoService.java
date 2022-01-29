package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Lancamento;
import com.dev.controleGastos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public void salvar(Lancamento lancamento){
        repository.save(lancamento);
    }

    public List<Lancamento> getLancamentos(){
        return repository.findAll();
    }
}
