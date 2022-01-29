package com.dev.controleGastos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private TipoLancamento tipo;
    private Date data;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany
    @JoinColumn(name = "id_lacamento")
    private List<LancamentoBaixa> lancamentoBaixas;
}
