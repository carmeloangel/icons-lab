package com.alkemy.icons.icons.entity;

import lombok.Getter; //Dependencia de lombor para crear los getters de manera automática
import lombok.Setter; //Dependencia de lombor para crear los setters de manera automática

import javax.persistence.*; //Dependencia para trabajar con entidades que persisten en disco

@Entity //Pertenece a la dependencia javax.persistence . Indica que es una entidad
@Table(name = "continente") //Tabla que va a utilizar dicha entidad. Tambien es de la dependencia javax.persistence
@Getter //Agregada de la dependendia lombok. Define un getter automatico para cada atributo
@Setter //Agregada de la dependendia lombok. Define un setter automatico para cada atributo

public class ContinenteEntity {

    @Id //Indica que es un identificador, es decir, el numero para el indexad0
    @Column //Sirve para redefinir el nombre. En este caso no redefine el Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE) //La forma en que se genera automatico el Id

    private Long id;

    private String imagen;

    private String denominacion;

}
