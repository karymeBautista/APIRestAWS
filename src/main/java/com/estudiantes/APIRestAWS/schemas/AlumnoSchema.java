package com.estudiantes.APIRestAWS.schemas;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class AlumnoSchema {
    @Id
    @Column(name = "alumno_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "promedio", nullable = false)
    private double promedio;

    @Column(name = "fotoPerfilURL", nullable = true)
    private String fotoPerfilUrl;

    @Column(name = "password", nullable = false)
    private String password;
}
