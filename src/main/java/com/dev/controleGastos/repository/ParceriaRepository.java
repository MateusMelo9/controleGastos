package com.dev.controleGastos.repository;

import com.dev.controleGastos.model.Parceria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParceriaRepository extends JpaRepository<Parceria,Integer> {
}
