package com.estudiantes.APIRestAWS.dto;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AlumnoDTO {
    private int id;
    private String nombres;
    private String apellidos;
    private String matricula;
    private double promedio;
}
