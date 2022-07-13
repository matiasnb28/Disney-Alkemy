package com.disney.repositories;

import com.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<PersonajeEntity, String> {



}
