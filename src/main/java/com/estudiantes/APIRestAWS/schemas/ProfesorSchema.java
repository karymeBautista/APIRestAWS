package com.estudiantes.APIRestAWS.schemas;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "profesor")
public class ProfesorSchema {
    @Id
    @Column(name = "profesor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numeroEmpleado", nullable = false, unique = true)
    private int numeroEmpleado;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "horasClase", nullable = false)
    private  int horasClase;
}
