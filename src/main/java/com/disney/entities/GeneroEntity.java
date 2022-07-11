
package com.disney.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "genero")
@Getter
@Setter
@SQLDelete(sql = "UPDATE Genero SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class GeneroEntity {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private boolean deleted = Boolean.FALSE;
   
    
    private String imagen;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pelicula_id", insertable = false, updatable = false)
    private List<PeliculaEntity> peliculas;

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
//     * @return the nombre
//     */
//    public String getNombre() {
//        return nombre;
//    }
//
//    /**
//     * @param nombre the nombre to set
//     */
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
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
//     * @return the pelicula
//     */
//    public PeliculaEntity getPelicula() {
//        return pelicula;
//    }
//
//    /**
//     * @param pelicula the pelicula to set
//     */
//    public void setPelicula(PeliculaEntity pelicula) {
//        this.pelicula = pelicula;
//    }
//    
    
}
