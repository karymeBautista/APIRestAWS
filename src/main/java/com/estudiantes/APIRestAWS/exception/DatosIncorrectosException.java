package com.estudiantes.APIRestAWS.exception;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class DatosIncorrectosException extends RuntimeException {
    private final String message;
    private final String details;
}
