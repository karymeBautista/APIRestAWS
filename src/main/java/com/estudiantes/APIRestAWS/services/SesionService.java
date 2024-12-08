package com.estudiantes.APIRestAWS.services;

import com.estudiantes.APIRestAWS.entity.Sesion;
import com.estudiantes.APIRestAWS.repositories.SesionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SesionService {
    private final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    public Sesion createSesion(Sesion sesion){
        String uuid = UUID.randomUUID().toString();
        sesion.setId(uuid);
        sesion.setActive(true);
        sesion.setFecha(System.currentTimeMillis());
        sesionRepository.save(sesion);
        return sesion;
    }

    public Sesion verifySesion(String sessionString){
        Sesion sesionAux = sesionRepository.getSessionBySessionString(sessionString);
        if (sesionAux != null && sesionAux.getActive()) {
            return sesionAux;
        }
        return null;
    }

    public Sesion logOut(String sessionString){
        Sesion sesionAux = sesionRepository.getSessionBySessionString(sessionString);
        if (sesionAux != null && sesionAux.getActive()) {
            sesionAux.setActive(false);
            sesionRepository.save(sesionAux);
            return sesionAux;
        }
        return null;
    }
}
