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
public class Conta implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String agencia;
    private String conta;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @OneToMany(mappedBy = "conta")
    private List<Lancamento> lancamentos;

}
