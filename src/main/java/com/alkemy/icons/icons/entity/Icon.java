package com.alkemy.icons.icons.entity;

import lombok.Getter; //Dependencia de lombor para crear los getters de manera automática
import lombok.Setter; //Dependencia de lombor para crear los setters de manera automática
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*; //Dependencia para trabajar con entidades que persisten en disco
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //Pertenece a la dependencia javax.persistence . Indica que es una entidad
@Getter //Agregada de la dependendia lombok. Define un getter automatico para cada atributo
@Setter //Agregada de la dependendia lombok. Define un setter automatico para cada atributo

//Lo que sigue es el SoftDelete
//@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
//@Where(clause = "deleted = false")

public class Icon {

    @Id //Indica que es un identificador, es decir, el numero para el indexado
    @GeneratedValue (strategy = GenerationType.IDENTITY) //La forma en que se genera automatico el Id
    private Long id;

    private String imagen; //Podemos suponer que es la URL a una imagen
    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long altura;
    private String historia;

    //private boolean deleted = Boolean.FALSE; //Parte del SoftDelete

    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "pais_id")
    //private PaisEntity pais;

    /**
     * Cuando se crea un ícono, no se puede pasar una lista de paises para que los cree. No tiene sentido porque los
     * paises existen antes que los icónos.
     */
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<Pais> paises = new ArrayList<>();

    //Agregar y remover paises
    public void addPais(Pais pais) { this.paises.add(pais); }
    public void removePais(Pais pais) { this.paises.remove(pais); }
}
