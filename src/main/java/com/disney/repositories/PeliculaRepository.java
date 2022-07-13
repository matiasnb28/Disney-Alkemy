package com.disney.repositories;

import com.disney.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, String> {

    @Query("SELECT P FROM pelicula P where P.genero.idGenero = :genero")
    List<PeliculaEntity> buscarPeliculaPorGenero(@Param("genero") String genero);

}
