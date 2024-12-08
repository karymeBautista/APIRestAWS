package com.estudiantes.APIRestAWS.repositories;

import com.estudiantes.APIRestAWS.schemas.ProfesorSchema;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorSchema, Integer> {
    Optional<ProfesorSchema> findById(int id);
    @NotNull
    List<ProfesorSchema> findAll();
}
