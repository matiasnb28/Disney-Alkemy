package com.disney.servicies;

import com.disney.dto.GeneroDTO;
import com.disney.dto.GeneroDTOMin;
import com.disney.dto.PersonajeDTO;
import com.disney.entities.GeneroEntity;
import com.disney.entities.PeliculaEntity;
import com.disney.entities.PersonajeEntity;
import com.disney.mappers.GeneroMapper;
import com.disney.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private GeneroMapper generoMapper;

    public GeneroDTO saveGenero(GeneroDTO generoDTO) throws Exception {
        validator(generoDTO);
        GeneroEntity genero = generoMapper.GeneroDTOToGenero(generoDTO);
        generoRepository.save(genero);
        return generoMapper.GeneroToGeneroDTO(genero);
    }

    public GeneroDTO updateGenero(GeneroDTO generoDTO) throws Exception {
        if (generoRepository.existsById(generoDTO.getId())){
             validator(generoDTO);
                GeneroEntity genero = generoMapper.GeneroDTOToGenero(generoDTO);
                genero = generoRepository.save(genero);
                return generoMapper.GeneroToGeneroDTO(genero);
        } else {
            throw new Exception("No se encontró el género solicitado.");
        }
    }

    public void deleteGenero(String id) throws Exception {
        if (generoRepository.existsById(id)){
            generoRepository.deleteById(id);
        } else {
            throw new Exception("No se encontró el género que intenta eliminiar.");
        }
    }

    public GeneroDTO getGenero(String id) throws Exception {
        if (generoRepository.existsById(id)) {
            GeneroEntity genero = generoRepository.getById(id);
            return generoMapper.GeneroToGeneroDTO(genero);
        } else {
            throw new Exception("No se encontró el género solicitado.");
        }
    }

    public List<GeneroDTOMin> getAllGeneros(){
        List<GeneroEntity> generos = generoRepository.findAll();
        return generoMapper.toListGeneroDTOMin(generos);
    }






    /*public GeneroDTO findById(String id) throws Exception {
        Optional<GeneroEntity> respuesta = generoRepository.findById(id);
        if (respuesta.isPresent()){
            GeneroEntity genero = respuesta.get();
            return generoMapper.GeneroToGeneroDTO(genero);
        }else{
            throw new Exception("No se encontró el genero que está buscando.");
        }
    }*/


    public void validator(GeneroDTO generoDTO) throws Exception {

        if (generoDTO.getNombre() == null || generoDTO.getNombre().trim().isEmpty()){
            throw new Exception("El nombre ingresado no es correcto.");
        }
        if (generoDTO.getImagen() == null || generoDTO.getImagen().trim().isEmpty()){
            throw new Exception("La imagen ingresada no es correcta.");
        }
        if (generoDTO.getPeliculas() == null || generoDTO.getPeliculas().isEmpty()){
            throw new Exception("Las películas ingresadas no son correctas.");
        }

    }
}
