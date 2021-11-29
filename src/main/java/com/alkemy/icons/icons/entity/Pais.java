package com.alkemy.icons.icons.entity;

import lombok.Getter; //Dependencia de lombor para crear los getters de manera automática
import lombok.Setter; //Dependencia de lombor para crear los setters de manera automática

import javax.persistence.*; //Dependencia para trabajar con entidades que persisten en disco
import java.util.HashSet;
import java.util.Set;

@Entity //Pertenece a la dependencia javax.persistence . Indica que es una entidad
@Getter //Agregada de la dependendia lombok. Define un getter automatico para cada atributo
@Setter //Agregada de la dependendia lombok. Define un setter automatico para cada atributo

public class Pais {

    @Id //Indica que es un identificador, es decir, el numero para el indexado
    @GeneratedValue (strategy = GenerationType.IDENTITY) //La forma en que se genera automatico el Id
    private Long id;

    private String imagen;
    private String denominacion;

    @Column(name = "cant_habitantes") //Redefinimos la variable que esta abajo porque en base de datos no se usa camelCase, por ello se la pone separada por guion bajo "_"
    private Long cantidadHabitantes;

    private Long superficie; //Expresado en metros cuadrados (m2)

    //Lo que sigue solo busca informacion, por como esta definido
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //FetchType.EAGER cuando se pide un dato de este tipo (pais) vendra con si o si con su continente (Inicalizacion temprana). Cascadetype = ALL para que cuando haga un delete tambien borre los continentes en la BD
    @JoinColumn(name = "continente_id", insertable = false, updatable = false) //El Join se hace a traves del atributo continente Id
    //Las propiedades insertable y updatable estan en false, porque solo lo uso para obtener datos de la BD
    private Continente continente; //Este es el atributo continenteID que lo definimos como de tipo ContinenteEntity
    // ya que dentro ya contiene el ID en si, o sea trae el continente y todos su datos

    //Esto estaría sobrando porque en arriba en el @JoinColumn("continente_id") se lo crea automáticamente.
    //@Column(name = "continente_id", nullable = false) //Redefinimos el id como continente_id usando el "_". Y le indicamos que no puede ser nulo
    //private Long continenteId;

    /**
     * Quien toma el OwnerShip, es decir quien se hace cargo de la relacion con los iconos, es el páis.
     * El país, al ser creado se le pasa una lista de iconos.
     * Esto porque el pais esite antes de cualqueir icono. La deificion va del lado del pais.
     */
    @ManyToMany(
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(
            name = "icon_pais", //Tabla intermedia, que define la relacion
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id") //Esto se da del lado inverso, es decir desde la entidad Icon se relaciona al pais con icon_id
    )
    private Set<Icon> icons = new HashSet<>();

    //Redefinimos la comparacion de paises
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final Pais that = (Pais) o;
        return (that.id == this.id);
    }

}
