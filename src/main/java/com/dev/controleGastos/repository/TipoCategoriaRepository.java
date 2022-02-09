package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCategoriaRepository extends JpaRepository<TipoCategoria,Integer> {
}
