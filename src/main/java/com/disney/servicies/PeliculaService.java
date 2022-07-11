
package com.disney.servicies;

import com.disney.dto.PeliculaDTO;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {
    
    public PeliculaDTO save(PeliculaDTO dto){
        //save
        System.out.println("Guardar pelicula");
        return dto;
        
    }
}
