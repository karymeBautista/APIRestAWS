package com.estudiantes.APIRestAWS.services;

import java.util.*;
import com.estudiantes.APIRestAWS.dto.ProfesorDTO;
import com.estudiantes.APIRestAWS.dto.request.PreProfesorInfo;
import com.estudiantes.APIRestAWS.exceptions.BusinessException;
import com.estudiantes.APIRestAWS.repositories.ProfesorRepository;
import com.estudiantes.APIRestAWS.schemas.ProfesorSchema;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository){
        this.profesorRepository = profesorRepository;
    }

    public List<ProfesorDTO> getProfesores(){
        return profesorRepository
                .findAll()
                .stream()
                .map(ProfesorDTO::getFromSchema)
                .toList();
    }

    public ProfesorDTO getProfesorById(int id){
        Optional<ProfesorSchema> profesor = profesorRepository
                .findById(id);
        return profesor.map(ProfesorDTO::getFromSchema).orElse(null);
    }

    public ProfesorDTO createProfesor(PreProfesorInfo profesorAux){
        if(profesorRepository.findById(profesorAux.getId()).isPresent()){
            throw BusinessException
                    .builder()
                    .message("Mismo id")
                    .build();
        }

        ProfesorSchema profesorSchema = new ProfesorSchema();
        profesorSchema.setNombres(profesorAux.getNombres());
        profesorSchema.setApellidos(profesorAux.getApellidos());
        profesorSchema.setHorasClase(profesorAux.getHorasClase());
        profesorSchema.setNumeroEmpleado(profesorAux.getNumeroEmpleado());

        ProfesorSchema profesorGuadado = profesorRepository.save(profesorSchema);

        return ProfesorDTO.getFromSchema(profesorGuadado);

    }

    public ProfesorDTO actualizar(int id, PreProfesorInfo profesorAux){
        Optional<ProfesorSchema> profesorExistente = profesorRepository.findById(id);

        if (profesorExistente.isPresent()) {
            ProfesorSchema profesor = profesorExistente.get();
            profesor.setNumeroEmpleado(profesorAux.getNumeroEmpleado());
            profesor.setNombres(profesorAux.getNombres());
            profesor.setApellidos(profesorAux.getApellidos());
            profesor.setHorasClase(profesorAux.getHorasClase());

            ProfesorSchema profesorActualizado = profesorRepository.save(profesor);

            return ProfesorDTO.getFromSchema(profesorActualizado);
        } else {
            return null;
        }
    }

    public ProfesorDTO deleteProfesor(int id){
        Optional<ProfesorSchema> profesorAEliminar = profesorRepository.findById(id);

        if (profesorAEliminar.isPresent()) {
            profesorRepository.deleteById(id);
            return ProfesorDTO.getFromSchema(profesorAEliminar.get());
        } else {
            return null;
        }
    }
}
