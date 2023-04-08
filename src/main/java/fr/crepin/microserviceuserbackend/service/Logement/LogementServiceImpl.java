package fr.crepin.microserviceuserbackend.service.Logement;

import fr.crepin.microserviceuserbackend.config.JwtService;
import fr.crepin.microserviceuserbackend.converter.LogementConverter;
import fr.crepin.microserviceuserbackend.dao.entity.Logement;
import fr.crepin.microserviceuserbackend.dao.repository.LogementRepository;
import fr.crepin.microserviceuserbackend.dto.logement.LogementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class LogementServiceImpl implements LogementService{

    private LogementRepository repository;

    private JwtService jwtService;

    @Autowired
    public LogementServiceImpl(LogementRepository repository, JwtService jwtService){
        this.repository = repository;
        this.jwtService = jwtService;
    }
    public List<Logement> getAllLogements(){
        return repository.findAll();
    }

    public Logement addLogement(LogementDto logementDto){
            Logement logement = LogementConverter.logementDtoToLogemetnConverter(logementDto);
            var t = repository.save(logement);
            return t;
    }

    @Override
    public Logement getLogementById(String id) {
        try{

        var logement = repository.findById(UUID.fromString(id));
        if(logement.isPresent()){
            return logement.get();
        }
        }catch (Exception e){

            throw new IllegalArgumentException("Logement not found with this id");
        }
        throw new IllegalArgumentException("Logement not found with this id");
    }

    @Override
    public List<Logement> getUserLogement(String jwt) {
        String username = jwtService.extractUsernameOrEmail(jwt);
        try{
            return repository.findByUsername(username);
        }catch (Exception e){
            throw new IllegalArgumentException("Error when getting logements for this user");
        }

    }

    @Override
    public Logement updateLogement(LogementDto logementDto) {
        Logement logement = LogementConverter.logementDtoToLogemetnConverter(logementDto);
        return repository.save(logement);
    }

}
