package com.dev.controleGastos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Casa implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Endereco endereco;
    private double valorTerreno;

    @OneToMany
    @JoinColumn(name = "id_casa")
    private List<Parceria> parcerias;

    @OneToMany
    @JoinColumn(name = "id_casa")
    private List<Gastos> gastos;
}
