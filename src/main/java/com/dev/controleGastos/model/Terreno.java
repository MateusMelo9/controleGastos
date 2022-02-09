package com.dev.controleGastos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terreno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double valor;
    private double taxaDocumentacao;
    @OneToOne
    private Endereco endereco;
}
