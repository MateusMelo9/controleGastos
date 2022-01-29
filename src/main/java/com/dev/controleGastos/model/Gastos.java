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
public class Gastos implements Serializable {

    private static final long serialVersionUis = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public Date data;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @ManyToMany
    @JoinTable(name = "gastos_material",
        uniqueConstraints = @UniqueConstraint(columnNames = {"gastos_id","material_id"}),
        joinColumns = @JoinColumn(name = "gastos_id"),
        inverseJoinColumns = @JoinColumn(name = "material_id"))
    private List<Material> materiais;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
