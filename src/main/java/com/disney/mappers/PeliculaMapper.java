package com.disney.mappers;

import com.disney.dto.PeliculaDTO;
import com.disney.entities.PeliculaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {
    @Mappings({
            @Mapping(target = "fechaCreacion", source = "fechaCreacion", dateFormat = "dd-MM-yyyy")
    })
    PeliculaEntity peliculaDTOToPelicula(PeliculaDTO peliculaDTO);

    @Mappings({
            @Mapping(target = "fechaCreacion", source = "fechaCreacion", dateFormat = "dd-MM-yyyy")
    })
    PeliculaDTO peliculaToPeliculaDTO(PeliculaEntity peliculaEntity);
}
