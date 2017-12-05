package com.prana.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class Cliente {

    @Id
    @Getter
    @Setter
    private Integer id;
    @Column
    @Getter
    @Setter
    private String nombre;


}
