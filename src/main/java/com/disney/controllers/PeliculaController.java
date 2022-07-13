
package com.disney.controllers;

import com.disney.dto.PeliculaDTO;
import com.disney.servicies.Impl.PeliculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {
    
    @Autowired
    private PeliculaServiceImpl peliculaServiceImpl;
    
    @PostMapping("/save")
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula){
        PeliculaDTO peliculaGuardada = peliculaServiceImpl.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }
}
