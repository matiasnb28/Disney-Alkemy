package com.disney.servicies;

import com.disney.dto.PersonajeDTO;
import com.disney.dto.PersonajeDTOMin;
import com.disney.entities.PeliculaEntity;
import com.disney.entities.PersonajeEntity;
import com.disney.mappers.PersonajeMapperImpl;
import com.disney.repositories.PersonajeRepository;
import com.disney.repositories.specifications.PersonajeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonajeService {


    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PersonajeMapperImpl personajeMapper;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private PersonajeSpecification personajeSpecification;

    @Transactional
    public List<PersonajeDTOMin> getAllPersonajes(){
        List<PersonajeEntity> personajes = personajeRepository.findAll();
        return personajeMapper.toListPersonajeDTOMinList(personajes);
    }
    @Transactional
    public PersonajeDTO savePersonaje(PersonajeDTO personajeDTO) throws Exception {
      validator(personajeDTO);
        PersonajeEntity personaje = personajeMapper.personajeDTOToPersonaje(personajeDTO);
        personaje = personajeRepository.save(personaje);
        return personajeMapper.personajeToPersonajeDTO(personaje);
    }
    @Transactional
    public PersonajeDTO updatePersonaje(PersonajeDTO personajeDTO) throws Exception {
        validator(personajeDTO);
        PersonajeDTO personajeDTO1 = findById(personajeDTO.getId()); //TODO preguntar si es mejor usar este método o usar el existbyid
        PersonajeEntity personaje = personajeMapper.personajeDTOToPersonaje(personajeDTO1);
        personaje = personajeRepository.save(personaje);
        return personajeMapper.personajeToPersonajeDTO(personaje);
    }
   /* public void deletePersonaje(String id){
        PersonajeDTO personajeDTO = findById(id);
        personajeRepository.delete(personajeDTO);

    }*/

    public void deletePersonaje(String id) throws Exception {
        if (personajeRepository.existsById(id)) {
            unPersonaje(id); // Method name inspired by orwell's 1984.
            personajeRepository.deleteById(id);
        } else {
            throw new Exception("No se pudo eliminar el personaje seleccionado.");
        }
    }
    public List<PersonajeDTO> getPersonajesByFilters(String nombre, Integer edad, List<String> peliculas) {
        List<PersonajeEntity> personajes = personajeRepository.findAll(
                personajeSpecification.getByFilters(nombre, edad, peliculas));
        return personajeMapper.toListPersonajeDTO(personajes);
    }
   private void unPersonaje(String id) throws Exception {
       // In 1984, George Orwell created the concept of the unperson, someone who had been executed and of whose existence all records were erased.
       PersonajeEntity personaje = personajeRepository.getById(id);
       if (!personaje.getPeliculas().isEmpty()) {
           List<PeliculaEntity> peliculas = personaje.getPeliculas();
           for (PeliculaEntity pelicula : peliculas) {
               peliculaService.removePersonajeFromPelicula(personaje.getId(), pelicula.getId());
           }
       }
   }


    public PersonajeDTO findById(String id) throws Exception {
        Optional<PersonajeEntity> respuesta = personajeRepository.findById(id);
        if (respuesta.isPresent()){
            PersonajeEntity personaje = respuesta.get();
            return personajeMapper.personajeToPersonajeDTO(personaje);
        }else{
            throw new Exception("No se encontró el personaje que está buscando.");
        }
    }
    public void validator(PersonajeDTO personajeDTO) throws Exception {
        if(personajeDTO.getImagen() == null || personajeDTO.getImagen().isEmpty()){
            throw new Exception("Ingrese una imagen válida.");
        }
        if (personajeDTO.getNombre() == null || personajeDTO.getNombre().isEmpty()){
            throw new Exception("Ingrese un nombre válido.");
        }
        if (personajeDTO.getEdad() == null || personajeDTO.getEdad() < 0){
            throw new Exception("Ingrese una edad válida.");
        }
        if (personajeDTO.getPeso() == null || personajeDTO.getPeso() < 0){
            throw new Exception("Ingrese un peso válido.");
        }
        if (personajeDTO.getHistoria() == null || personajeDTO.getHistoria().isEmpty());
    }

}
