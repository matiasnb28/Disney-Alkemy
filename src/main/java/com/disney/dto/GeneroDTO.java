package com.disney.dto;

import com.disney.entities.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter

public class GeneroDTO {

    private String id;
    private String nombre;


    private String imagen;

    private List<PeliculaEntity> peliculas;
}
