
package com.disney.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
                    cascade = {                                                                                    //Cuando creo una película, creo los personajes y no cuando creo los personajes, creo la película
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                    })
    @JoinTable(
                name = "personaje_pelicula",
                joinColumns = @JoinColumn (name = "pelicula_id"),
                inverseJoinColumns = @JoinColumn (name = "personaje_id"))
    private List<PersonajeEntity> personajes = new ArrayList();

//    /**
//     * @return the id
//     */
//    public String getId() {
//        return id;
//    }
//
//    /**
//     * @param id the id to set
//     */
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    /**
//     * @return the imagen
//     */
//    public String getImagen() {
//        return imagen;
//    }
//
//    /**
//     * @param imagen the imagen to set
//     */
//    public void setImagen(String imagen) {
//        this.imagen = imagen;
//    }
//
//    /**
//     * @return the titulo
//     */
//    public String getTitulo() {
//        return titulo;
//    }
//
//    /**
//     * @param titulo the titulo to set
//     */
//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//    }
//
//    /**
//     * @return the fechaCreacion
//     */
//    public Date getFechaCreacion() {
//        return fechaCreacion;
//    }
//
//    /**
//     * @param fechaCreacion the fechaCreacion to set
//     */
//    public void setFechaCreacion(Date fechaCreacion) {
//        this.fechaCreacion = fechaCreacion;
//    }
//
//    /**
//     * @return the calificacion
//     */
//    public String getCalificacion() {
//        return calificacion;
//    }
//
//    /**
//     * @param calificacion the calificacion to set
//     */
//    public void setCalificacion(String calificacion) {
//        this.calificacion = calificacion;
//    }
//
//    /**
//     * @return the personajes
//     */
//    public Set<PersonajeEntity> getPersonajes() {
//        return personajes;
//    }
//
//    /**
//     * @param personajes the personajes to set
//     */
//    public void setPersonajes(Set<PersonajeEntity> personajes) {
//        this.personajes = personajes;
//    }
    
}
