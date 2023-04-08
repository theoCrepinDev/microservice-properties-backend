package fr.crepin.microserviceuserbackend.service.Logement;

import fr.crepin.microserviceuserbackend.dao.entity.Logement;
import fr.crepin.microserviceuserbackend.dto.logement.LogementDto;

import java.util.List;

public interface LogementService {

    List<Logement> getAllLogements();

    Logement addLogement(LogementDto logement);

    Logement getLogementById(String id);

    List<Logement> getUserLogement(String jwt);

    Logement updateLogement(LogementDto logementDto);
}
