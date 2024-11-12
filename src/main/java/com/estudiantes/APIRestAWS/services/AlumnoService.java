package com.estudiantes.APIRestAWS.services;

import com.estudiantes.APIRestAWS.dto.AlumnoDTO;
import com.estudiantes.APIRestAWS.dto.request.PreAlumnoInfo;

import org.springframework.stereotype.Service;


import java.util.*;
@Service
public class AlumnoService {
    private List<AlumnoDTO> alumnos = new ArrayList<>();

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        //  this.alumnos.add(new AlumnoDTO(1,"Nombre1", "apellido", 12234, 90.0));
        //  this.alumnos.add(new AlumnoDTO(2,"Nombre1", "apellido", 12234, 90.0));
    }

    public List<AlumnoDTO> getAlumnos() {
        return alumnos;
    }

    public AlumnoDTO getAlumnoById(int id){
        for (AlumnoDTO alumno : alumnos) {
            if (alumno.getId() == id) {
                return alumno;
            }
        }
        return null;
    }

    public AlumnoDTO createAlumno(PreAlumnoInfo alumnoAux){
        AlumnoDTO nuevoAlumno = new AlumnoDTO(alumnoAux.getId(), alumnoAux.getNombres(), alumnoAux.getApellidos(), alumnoAux.getMatricula(), alumnoAux.getPromedio());

        alumnos.add(nuevoAlumno);
        return nuevoAlumno;
    }

    public AlumnoDTO actualizar(int id, PreAlumnoInfo alumnoAux){
        Optional<AlumnoDTO> alumnoExistente = alumnos.stream().filter(a -> a.getId() == id).findFirst();
        alumnoExistente.ifPresent(value -> {
            value.setNombres(alumnoAux.getNombres());
            value.setApellidos(alumnoAux.getApellidos());
            value.setMatricula(alumnoAux.getMatricula());
            value.setPromedio(alumnoAux.getPromedio());
        });
        return alumnoExistente.orElse(null);
    }

    public AlumnoDTO deleteAlumno(int id){
        AlumnoDTO alumnoAEliminar = null;
        for (AlumnoDTO alumno : alumnos) {
            if (alumno.getId() == id) {
                alumnoAEliminar = alumno;
                break; // Salir del bucle una vez que se encuentre el alumno con el ID buscado
            }
        }

        if (alumnoAEliminar != null) {
            alumnos.remove(alumnoAEliminar);
            System.out.println("Alumno con ID " + id + " eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún alumno con el ID: " + id);
        }

        return alumnoAEliminar;
    }

}
