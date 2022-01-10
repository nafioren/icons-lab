package com.alkemy.icons.icons.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pais")
@Getter
@Setter
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie; // m2



    // *** Para BUSCAR Informacion (Dentro del Objeto ContinenteEntity) y armar Listas ***
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    // *** Para Guardar y Actualizar ***
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    // ***
    // Cuando creamos Pais, podemos pasarle Lista de Iconos
    // Creamos Tabla Intermedia "icon_pais"
    //***
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "icon_pais",
            joinColumns= @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();



    // Metodos



    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final PaisEntity other = (PaisEntity) obj;
        return other.id ==this.id;
    }

}