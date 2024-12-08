package com.estudiantes.APIRestAWS.dto;
import com.estudiantes.APIRestAWS.schemas.ProfesorSchema;
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

    public static ProfesorDTO getFromSchema(ProfesorSchema profesorSchema){
        return ProfesorDTO
                .builder()
                .id(profesorSchema.getId())
                .nombres(profesorSchema.getNombres())
                .apellidos(profesorSchema.getApellidos())
                .horasClase(profesorSchema.getHorasClase())
                .numeroEmpleado(profesorSchema.getNumeroEmpleado())
                .build();
    }
}
