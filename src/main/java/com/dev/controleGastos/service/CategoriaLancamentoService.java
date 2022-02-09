package com.dev.controleGastos.service;

import com.dev.controleGastos.model.CategoriaLancamento;
import com.dev.controleGastos.repository.CategoriaLancamentoRepository;
import com.dev.controleGastos.service.exception.CategoriaJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaLancamentoService {

    @Autowired
    private CategoriaLancamentoRepository repository;

    @Transactional
    public CategoriaLancamento salvar(CategoriaLancamento categoria){
        Optional<CategoriaLancamento> categoriaOptional = repository.findByNomeIgnoreCase(categoria.getNome());
        if(categoriaOptional.isPresent()){
            throw new CategoriaJaCadastradoException("Categoria já cadastrado!");
        }
        return repository.saveAndFlush(categoria);
    }

    public List<CategoriaLancamento> getCategoriasLancamento(){
        return repository.findAll();
    }
}
