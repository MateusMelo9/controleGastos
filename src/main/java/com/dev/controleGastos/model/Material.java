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
public class Material implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private double valor;
    @OneToOne
    private Fornecedor fornecedor;
    @ManyToMany
    @JoinTable(name = "gastos_material",
            uniqueConstraints = @UniqueConstraint(columnNames = {"gastos_id","material_id"}),
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "gastos_id"))
    private List<Gastos> gastos;
}
