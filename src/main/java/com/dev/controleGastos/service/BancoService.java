package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Banco;
import com.dev.controleGastos.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository repository;

    public void salvar(Banco banco){
        repository.save(banco);
    }

    public List<Banco> getBancos(){
        return repository.findAll();
    }
}
