package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.CategoriaLancamento;
import com.dev.controleGastos.model.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaLancamentoRepository extends JpaRepository<CategoriaLancamento,Integer> {

    public Optional<CategoriaLancamento> findByNomeIgnoreCase(String nome);

    public List<CategoriaLancamento> findBytipoCategoria(TipoCategoria tipoCategoria);
}
