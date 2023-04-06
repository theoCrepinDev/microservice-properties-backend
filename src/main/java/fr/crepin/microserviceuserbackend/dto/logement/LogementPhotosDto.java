package fr.crepin.microserviceuserbackend.dto.logement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogementPhotosDto {

    private String id;
    private String lien;
    private int position;

}
