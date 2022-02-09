package com.dev.controleGastos.service;

import com.dev.controleGastos.model.Conta;
import com.dev.controleGastos.model.Lancamento;
import com.dev.controleGastos.model.TipoLancamento;
import com.dev.controleGastos.repository.ContaRepository;
import com.dev.controleGastos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    public void salvar(Lancamento lancamento){
        lancamento.setData(new Date());
        calcularSaldo(lancamento);
        repository.save(lancamento);
    }

    public void calcularSaldo(Lancamento lancamento){
        Conta conta = lancamento.getConta();
        double saldo = conta.getSaldo();
        double valorLancamento = lancamento.getValor();
        if(lancamento.getTipo().equals(TipoLancamento.ENTRADA)){
            conta.setSaldo(saldo+valorLancamento);
        }else{
            conta.setSaldo(saldo-valorLancamento);
        }
        salvarConta(conta);
    }

    public void salvarConta(Conta conta){
        contaRepository.save(conta);
    }

    public List<Lancamento> getLancamentos(){
        return repository.findAll();
    }
}
