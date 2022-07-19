package com.disney.mappers;

import com.disney.dto.GeneroDTO;
import com.disney.dto.GeneroDTOMin;
import com.disney.entities.GeneroEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GeneroMapper {

    GeneroEntity GeneroDTOToGenero(GeneroDTO generoDTO);

    GeneroDTO GeneroToGeneroDTO(GeneroEntity generoEntity);

    List<GeneroDTOMin> toListGeneroDTOMin(List<GeneroEntity> generos);
}
