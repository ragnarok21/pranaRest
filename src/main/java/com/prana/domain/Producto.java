package com.prana.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    @Enumerated(value = EnumType.STRING)
    private TipoProducto tipoProducto;
    @Column
    private Integer precioUnidad;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stock_id")
    private Stock stock;
}
