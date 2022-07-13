
package com.disney.servicies.Impl;

import com.disney.dto.PeliculaDTO;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl {
    
    public PeliculaDTO save(PeliculaDTO dto){
        //save
        System.out.println("Guardar pelicula");
        return dto;
        
    }
}
