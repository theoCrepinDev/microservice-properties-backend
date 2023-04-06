package fr.crepin.microserviceuserbackend.controller;

import fr.crepin.microserviceuserbackend.converter.LogementConverter;
import fr.crepin.microserviceuserbackend.dao.entity.Logement;
import fr.crepin.microserviceuserbackend.dto.logement.LogementDto;
import fr.crepin.microserviceuserbackend.dto.logement.PostLogementResponse;
import fr.crepin.microserviceuserbackend.service.Logement.LogementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logements")
@CrossOrigin(origins = "${front.url}")
public class LogementController {


    private LogementService service;

    @Autowired
    public LogementController(LogementService service){
        this.service = service;
    }

    @GetMapping
    public List<LogementDto> getAllLogements(){
        var logements = this.service.getAllLogements();
        return logements.stream().map(LogementConverter::logementToLogementDtoConverter).toList();
    }

    @PostMapping
    public PostLogementResponse addLogement(@RequestBody  LogementDto logement){
        try{
            return PostLogementResponse
                    .builder()
                    .isValid(true)
                    .message("Logement ajouté avec succé")
                    .logementDto(
                        LogementConverter.logementToLogementDtoConverter(service.addLogement(logement))
                    )
                    .build();
        }catch (Exception e){
            return PostLogementResponse
                    .builder()
                    .isValid(false)
                    .message(e.getMessage())
                    .build();
        }

    }
}
