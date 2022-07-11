package com.disney.dto;

import com.disney.entities.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonajeDTO {

    private String id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;
    private List<PeliculaEntity> peliculas = new ArrayList<>();
}
