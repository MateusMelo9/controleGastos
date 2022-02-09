package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaRepository extends JpaRepository<Casa,Integer> {
}
