package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco,Integer> {
}
