package com.dev.controleGastos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banco implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    private Integer codigo;
    private String nome;

    @OneToMany
    @JoinColumn(name = "id_banco")
    private List<Conta> contas;


}
