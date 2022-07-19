package com.disney.mappers;

import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeDTOMin;
import com.disney.entities.PersonajeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonajeMapper {

    PersonajeEntity personajeDTOToPersonaje(PersonajeDTO personajeDTO);
    PersonajeDTO personajeToPersonajeDTO(PersonajeEntity personajeEntity);

     List<PersonajeDTOMin> toListPersonajeDTOMinList(List<PersonajeEntity> personajes);

     List<PersonajeDTO> toListPersonajeDTO(List<PersonajeEntity> personajeEntity);

}
