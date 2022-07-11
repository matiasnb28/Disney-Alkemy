package com.disney.mappers;

import com.disney.dto.PersonajeDTO;
import com.disney.entities.PersonajeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PersonajeMapper {

    PersonajeEntity personajeDTOToPersonaje(PersonajeDTO personajeDTO);
    PersonajeDTO personajeToPersonajeDTO(PersonajeEntity personajeEntity);

}
