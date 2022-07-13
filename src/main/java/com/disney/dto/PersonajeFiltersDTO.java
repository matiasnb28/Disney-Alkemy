package com.disney.dto;

import com.disney.entities.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDTO {

    private String nombre;
    private Integer edad;
    private List<String> peliculas;

    public PersonajeFiltersDTO(String nombre, Integer edad, List<String> peliculas) {
        this.nombre = nombre;
        this.edad = edad;
        this.peliculas = peliculas;
    }

}
