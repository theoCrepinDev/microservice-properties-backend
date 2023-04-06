package fr.crepin.microserviceuserbackend.dto.logement;

import fr.crepin.microserviceuserbackend.dao.entity.LogementOptions;
import fr.crepin.microserviceuserbackend.enums.LogementOptionsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogementDto {
    private String id;
    private String titre;
    private int nbrPieces;
    private float taille;
    private int nbrEtages;
    private int prix;
    private String description;
    private List<LogementPhotosDto> photos;
    private List<LogementOptionsDto> options;
}
