
package com.disney.entities;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
@SQLDelete(sql = "UPDATE Pelicula SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PeliculaEntity {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String imagen;
    private boolean deleted = Boolean.FALSE;
    
    private String titulo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    private String calificacion; //Del 1 al 5
    
    @ManyToMany(                                                                                            //Esto quiere decir que la película va a ser el objeto que se haga cargo, es el "objeto mayor"
                    cascade = {                                                                             //Cuando creo una película, creo los personajes y no cuando creo los personajes, creo la película
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                    })
    @JoinTable(
                name = "personaje_pelicula",
                joinColumns = @JoinColumn (name = "pelicula_id"),
                inverseJoinColumns = @JoinColumn (name = "personaje_id"))
    private List<PersonajeEntity> personajes = new ArrayList();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    private GeneroEntity genero;
    
}
