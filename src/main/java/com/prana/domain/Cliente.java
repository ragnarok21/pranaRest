package com.prana.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String direccion;
    @Column
    private Integer telefono;
    @Column(nullable = true)
    @Email
    private String email;
    @Column
    private String empresa;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ciudad_id")
    private Ciudad ciudad;


}
