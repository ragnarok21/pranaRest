package com.prana.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Roles> roles;
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
