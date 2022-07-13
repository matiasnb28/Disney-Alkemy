package com.disney.dto;

import com.disney.entities.GeneroEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PeliculaFiltersDTO {

    private String titulo;
    private GeneroEntity genero;
    private String orden;

    public PeliculaFiltersDTO(String titulo, GeneroEntity genero, String orden) {
        this.titulo = titulo;
        this.genero = genero;
        this.orden = orden;
    }

    public boolean isASC() { return this.orden.compareToIgnoreCase("ASC") == 0; }

    public boolean isDESC() { return this.orden.compareToIgnoreCase("DESC") == 0; }

}
