
package com.disney.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE Personaje SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PersonajeEntity {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String imagen;
    private boolean deleted = Boolean.FALSE;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas = new ArrayList<>();

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
//     * @return the edad
//     */
//    public Integer getEdad() {
//        return edad;
//    }
//
//    /**
//     * @param edad the edad to set
//     */
//    public void setEdad(Integer edad) {
//        this.edad = edad;
//    }
//
//    /**
//     * @return the peso
//     */
//    public Float getPeso() {
//        return peso;
//    }
//
//    /**
//     * @param peso the peso to set
//     */
//    public void setPeso(Float peso) {
//        this.peso = peso;
//    }
//
//    /**
//     * @return the historia
//     */
//    public String getHistoria() {
//        return historia;
//    }
//
//    /**
//     * @param historia the historia to set
//     */
//    public void setHistoria(String historia) {
//        this.historia = historia;
//    }
//
//    /**
//     * @return the peliculas
//     */
//    public List<PeliculaEntity> getPeliculas() {
//        return peliculas;
//    }
//
//    /**
//     * @param peliculas the peliculas to set
//     */
//    public void setPeliculas(List<PeliculaEntity> peliculas) {
//        this.peliculas = peliculas;
//    }
    
}
