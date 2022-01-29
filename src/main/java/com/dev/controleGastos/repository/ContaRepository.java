package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
