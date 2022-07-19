package com.disney.repositories;

import com.disney.entities.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<GeneroEntity, String> {


    List<GeneroEntity> findByName(String nombre);

}
