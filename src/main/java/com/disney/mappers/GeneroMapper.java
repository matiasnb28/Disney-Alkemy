package com.disney.mappers;

import com.disney.dto.GeneroDTO;
import com.disney.entities.GeneroEntity;
import org.mapstruct.Mapper;

@Mapper
public interface GeneroMapper {

    GeneroEntity GeneroDTOToGenero(GeneroDTO generoDTO);

    GeneroDTO GeneroToGeneroDTO(GeneroEntity generoEntity);
}
