package com.estudiantes.APIRestAWS.dto.request;
import jakarta.validation.constraints.*;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class PreProfesorInfo {
    private int id;

    @Positive(message = "El campo 'horasclase' debe ser un número entero mayor a 0")
    private int numeroEmpleado;

    @NotNull
    @NotBlank
    private String nombres;

    @NotNull
    @NotBlank
    private String apellidos;

    @Positive(message = "El campo 'horasClase' debe ser un número entero positivo")
    private  int horasClase;
}
