package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Casa;
import com.dev.controleGastos.model.Endereco;
import com.dev.controleGastos.model.Parceria;
import com.dev.controleGastos.model.Terreno;
import com.dev.controleGastos.repository.CasaRepository;
import com.dev.controleGastos.repository.EnderecoRepository;
import com.dev.controleGastos.repository.ParceriaRepository;
import com.dev.controleGastos.repository.TerrenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaService {

    @Autowired
    private CasaRepository casaRepository;

    @Autowired
    private TerrenoRepository terrenoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ParceriaRepository parceriaRepository;

    public void salvarCasa(Casa casa){
        salvarParceria(casa.getParceria());
        salvarTerreno(casa.getTerreno());
        casaRepository.save(casa);
    }

    public void salvarTerreno(Terreno terreno){
        salvarEndereco(terreno.getEndereco());
        terrenoRepository.save(terreno);
    }

    public void salvarEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    public void salvarParceria(Parceria parceria){
        parceriaRepository.save(parceria);
    }

    public List<Casa> getCasas(){
        return casaRepository.findAll();
    }
}
