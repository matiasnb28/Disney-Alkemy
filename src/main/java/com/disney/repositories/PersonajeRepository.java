package com.disney.repositories;

import com.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonajeRepository extends JpaRepository<PersonajeEntity, String> {

    List<PersonajeEntity> findByName(String nombre);

    List<PersonajeEntity> findAll(Specification<PersonajeEntity> spec);


}
