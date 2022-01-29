package com.dev.controleGastos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoBaixa implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private TipoLancamento tipo;
    private Date dataPagamento;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_lacamento")
    private Lancamento lacamento;

}
