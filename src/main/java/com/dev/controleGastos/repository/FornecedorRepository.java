package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {
}
