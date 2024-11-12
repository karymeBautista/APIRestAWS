package com.estudiantes.APIRestAWS.services;

import java.util.*;
import com.estudiantes.APIRestAWS.dto.ProfesorDTO;
import com.estudiantes.APIRestAWS.dto.request.PreProfesorInfo;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
    private List<ProfesorDTO> profesores = new ArrayList<>();

    public ProfesorService(){
        this.profesores = new ArrayList<>();
        //this.profesores.add(new ProfesorDTO(1,2, "Jun", "mauricio", 90));
        //this.profesores.add(new ProfesorDTO(2,4, "apellido", "12234", 90));
    }

    public List<ProfesorDTO> getProfesores(){
        return profesores;
    }

    public ProfesorDTO getProfesorById(int id){
        for (ProfesorDTO profesor : profesores) {
            if (profesor.getId() == id) {
                return profesor;
            }
        }
        return null;
    }

    public ProfesorDTO createProfesor(PreProfesorInfo profesorAux){
        ProfesorDTO nuevoProfesor = new ProfesorDTO(profesorAux.getId(), profesorAux.getNumeroEmpleado(), profesorAux.getNombres(), profesorAux.getApellidos(), profesorAux.getHorasClase());

        profesores.add(nuevoProfesor);
        return nuevoProfesor;
    }

    public ProfesorDTO actualizar(int id, PreProfesorInfo profesorAux){
        Optional<ProfesorDTO> profesorExistente = profesores.stream().filter(a -> a.getId() == id).findFirst();
        profesorExistente.ifPresent(value -> {
            value.setNumeroEmpleado(profesorAux.getNumeroEmpleado());
            value.setNombres(profesorAux.getNombres());
            value.setApellidos(profesorAux.getApellidos());
            value.setHorasClase(profesorAux.getHorasClase());
        });
        return profesorExistente.orElse(null);
    }

    public ProfesorDTO deleteProfesor(int id){
        ProfesorDTO profesorAEliminar = null;
        for (ProfesorDTO profesor : profesores) {
            if (profesor.getId() == id) {
                profesorAEliminar = profesor;
                break; // Salir del bucle una vez que se encuentre el alumno con el ID buscado
            }
        }

        if (profesorAEliminar != null) {
            profesores.remove(profesorAEliminar);
        }
        return profesorAEliminar;
    }
}
