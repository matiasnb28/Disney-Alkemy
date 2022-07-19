package com.disney.servicies;

import com.disney.entities.GeneroEntity;
import com.disney.entities.PeliculaEntity;
import com.disney.entities.PersonajeEntity;
import com.disney.repositories.GeneroRepository;
import com.disney.repositories.PeliculaRepository;
import com.disney.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private GeneroRepository generoRepository;



    public void removePersonajeFromPelicula(String personajeId, String peliculaId) throws Exception {
        if (personajeRepository.existsById(personajeId) &&
                peliculaRepository.existsById(peliculaId)) {
            PeliculaEntity pelicula = peliculaRepository.getById(peliculaId); //TODO preguntar porque no puedo usar findbyId sin el Option y porque queda tachado el get
            PersonajeEntity personaje = personajeRepository.getById(personajeId);
            List<PersonajeEntity> personajes = pelicula.getPersonajes();
            personajes.remove(personaje);
            pelicula.setPersonajes(personajes);
            peliculaRepository.save(pelicula);
        } else if (!personajeRepository.existsById(personajeId)) {
            throw new Exception("No se encontró el personaje que intenta buscar.");
        } else if (!peliculaRepository.existsById(peliculaId)) {
            throw new Exception("No se encontró la película que intenta buscar.");
        }
    }
}
