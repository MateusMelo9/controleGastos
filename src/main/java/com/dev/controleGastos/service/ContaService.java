package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Conta;
import com.dev.controleGastos.model.Lancamento;
import com.dev.controleGastos.repository.ContaRepository;
import com.dev.controleGastos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public void salvar(Conta conta){
        repository.save(conta);
    }

    public List<Conta> getContas(){
        return repository.findAll();
    }
}
