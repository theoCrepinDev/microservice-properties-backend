package fr.crepin.microserviceuserbackend.dto.logement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLogementResponse {
    private Boolean isValid;

    private String message;

    private LogementDto logementDto;
}
