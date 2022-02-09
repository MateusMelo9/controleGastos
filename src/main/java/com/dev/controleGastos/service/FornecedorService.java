package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Endereco;
import com.dev.controleGastos.model.Fornecedor;
import com.dev.controleGastos.repository.EnderecoRepository;
import com.dev.controleGastos.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void salvarForncedor(Fornecedor fornecedor){
        salvarEndereco(fornecedor.getEndereco());
        fornecedorRepository.save(fornecedor);
    }

    public void salvarEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    public List<Fornecedor> getForncedores(){
        return fornecedorRepository.findAll();
    }
}
