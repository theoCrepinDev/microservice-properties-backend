package fr.crepin.microserviceuserbackend.converter;

import fr.crepin.microserviceuserbackend.dao.entity.Logement;
import fr.crepin.microserviceuserbackend.dao.entity.LogementOptions;
import fr.crepin.microserviceuserbackend.dao.entity.LogementPhotos;
import fr.crepin.microserviceuserbackend.dto.logement.LogementDto;
import fr.crepin.microserviceuserbackend.dto.logement.LogementOptionsDto;
import fr.crepin.microserviceuserbackend.dto.logement.LogementPhotosDto;
import fr.crepin.microserviceuserbackend.enums.LogementOptionsEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class LogementConverter {

    public static LogementPhotosDto LogementPhotosToLogementPhotosDtoConverter(LogementPhotos logementPhotos){
        return LogementPhotosDto.builder().id(logementPhotos.getId().toString()).lien(logementPhotos.getLien()).position(logementPhotos.getPosition()).build();
    }

    public static LogementOptionsDto logementOptionsToLogementOptionDtoConverter(LogementOptions logementOptions){
        return LogementOptionsDto.builder()
                .id(logementOptions.getId().toString())
                .nom(logementOptions.getNom().toString())
                .build();
    }
    public static LogementDto logementToLogementDtoConverter(Logement logement){
        return LogementDto
                .builder()
                .description(logement.getDescription())
                .prix(logement.getPrix())
                .titre(logement.getTitre())
                .taille(logement.getTaille())
                .nbrEtages(logement.getNombreEtages())
                .nbrPieces(logement.getNombrePieces())
                .id(logement.getId().toString())
                .photos(logement.getLogementPhotos().stream().map(LogementConverter::LogementPhotosToLogementPhotosDtoConverter).toList())
                .options(logement.getLogementOptions() != null ? logement.getLogementOptions().stream().map(LogementConverter::logementOptionsToLogementOptionDtoConverter).toList(): Collections.emptyList())
                .build();
    }

    public static LogementPhotos logementPhotosDtoToLogementPhotos(LogementPhotosDto logementPhotosDto){
        var result = new LogementPhotos();
        result.setId(logementPhotosDto.getId() != null ?UUID.fromString(logementPhotosDto.getId()) : null);
        result.setLien(logementPhotosDto.getLien());
        result.setPosition(logementPhotosDto.getPosition());
        return result;
    }

    public static LogementOptions logementOptionsDtoToLogementOptionsConverter(LogementOptionsDto logementOptionsDto){
        var result = new LogementOptions();
        result.setNom(logementOptionsDto.getId() != null ? LogementOptionsEnum.valueOf(logementOptionsDto.getNom().toUpperCase()) : null);
        return result;
    }

    public static Logement logementDtoToLogemetnConverter(LogementDto logementDto){
        var result = new Logement();
        result.setDescription(logementDto.getDescription());
        result.setId(logementDto.getId() != null ? UUID.fromString(logementDto.getId()) : null);
        result.setPrix(logementDto.getPrix());
        result.setTaille(logementDto.getTaille());
        result.setNombreEtages(logementDto.getNbrEtages());
        result.setTitre(logementDto.getTitre());
        result.setNombrePieces(logementDto.getNbrPieces());

        logementDto.getPhotos().forEach(photo -> result.addPhoto(
                logementPhotosDtoToLogementPhotos(photo)
        ));

        if(logementDto.getOptions() != null && !logementDto.getOptions().isEmpty()){
            logementDto.getOptions().forEach(option -> result.addOption(
                    logementOptionsDtoToLogementOptionsConverter(option)
            ));
        }

        return result;
    }
}
