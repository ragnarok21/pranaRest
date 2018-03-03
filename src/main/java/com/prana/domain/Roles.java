package com.prana.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Roles {


    public Roles(String nombre){
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @Column
    private String nombre;
}
