
package com.disney.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.disney.entities.GeneroEntity;
import com.disney.entities.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaDTO {
    private String id;
    private String imagen;
    private String titulo;
    private String fechaCreacion;
    private Integer calificacion;

    private List<PersonajeEntity> personajes;

    private GeneroEntity genero;

}
