package com.estudiantes.APIRestAWS.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class PreAlumnoInfo {
    private int id;
    @NotNull
    @NotBlank
    private String nombres;
    @NotNull
    @NotBlank
    private String apellidos;

    @Pattern(regexp = "^[a-zA-Z]+\\d+$", message = "La matrícula debe comenzar con letras seguidas de al menos un número")
    private String matricula;
    @DecimalMin(value = "0.0", inclusive = true, message = "El campo 'promedio' debe ser un número decimal mayor o igual a 0")
    @DecimalMax(value = "100.0", inclusive = true, message = "El campo 'promedio' debe ser un número decimal menor o igual a 100")
    private double promedio;
    private String fotoPerfilUrl;

    private String password;
}
