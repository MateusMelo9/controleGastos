package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
}
