package fr.crepin.microserviceuserbackend.controller;

import fr.crepin.microserviceuserbackend.converter.LogementConverter;
import fr.crepin.microserviceuserbackend.dao.entity.Logement;
import fr.crepin.microserviceuserbackend.dao.entity.LogementOptions;
import fr.crepin.microserviceuserbackend.dto.logement.LogementDto;
import fr.crepin.microserviceuserbackend.dto.logement.PostLogementResponse;
import fr.crepin.microserviceuserbackend.service.Logement.LogementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${front.url}")
public class LogementController {


    private LogementService service;

    @Autowired
    public LogementController(LogementService service){
        this.service = service;
    }

    @GetMapping("/logements")
    public List<LogementDto> getAllLogements(
    ){
        var logements = this.service.getAllLogements();
        return logements.stream().map(LogementConverter::logementToLogementDtoConverter).toList();
    }

    @GetMapping("logements/me")
    public List<LogementDto> getUserLogements(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String language
    ){
        var logements = this.service.getUserLogement(language.split(" ")[1]);
        return logements.stream().map(LogementConverter::logementToLogementDtoConverter).toList();
    }

    @PostMapping("/logement")
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

    @GetMapping("/logement")
    public LogementDto getLogementById(
            @RequestParam String id
    ){
        return LogementConverter.logementToLogementDtoConverter(service.getLogementById(id));
    }

    @PutMapping("logement")
    public LogementDto putLogement(
            @RequestBody LogementDto logementDto
    ){
        return LogementConverter.logementToLogementDtoConverter(service.updateLogement(logementDto));
    }
}
