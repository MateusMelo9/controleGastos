package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.CategoriaLancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaLancamentoRepository extends JpaRepository<CategoriaLancamento,Integer> {

    public Optional<CategoriaLancamento> findByNomeIgnoreCase(String nome);
}
