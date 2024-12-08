package com.estudiantes.APIRestAWS.controller;
import com.estudiantes.APIRestAWS.dto.ProfesorDTO;
import com.estudiantes.APIRestAWS.dto.request.PreProfesorInfo;
import com.estudiantes.APIRestAWS.services.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@CrossOrigin(origins = {"*"})
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService){
        this.profesorService = profesorService;
    }

    @GetMapping("")
    @Operation(summary = "Obtener todos los profesores")
    public ResponseEntity<List<ProfesorDTO>> getAllProfesores() {
        List<ProfesorDTO> profesores = this.profesorService.getProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener profesor por ID")
    public ResponseEntity<ProfesorDTO> getProfesorById(@PathVariable int id){
        ProfesorDTO newProfesor = this.profesorService.getProfesorById(id);
        if(newProfesor == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newProfesor,HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo profesor")
    public ResponseEntity<ProfesorDTO> createProfesor(@Valid @RequestBody PreProfesorInfo info){
        ProfesorDTO newProfesor = this.profesorService.createProfesor(info);
        return new ResponseEntity<>(newProfesor,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar profesor por ID")
    public ResponseEntity<ProfesorDTO> editProfesorByid(@Valid @RequestBody PreProfesorInfo info, @PathVariable int id){
        ProfesorDTO newProfesor = this.profesorService.actualizar(id,info);
        return new ResponseEntity<>(newProfesor,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfesorDTO> delete(@PathVariable int id){
        ProfesorDTO newProfesor = this.profesorService.deleteProfesor(id);

        if (newProfesor != null) {
            return new ResponseEntity<>(newProfesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
