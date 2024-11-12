package com.estudiantes.APIRestAWS.dto;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProfesorDTO {
    private int id;
    private int numeroEmpleado;
    private String nombres;
    private String apellidos;
    private  int horasClase;
}
