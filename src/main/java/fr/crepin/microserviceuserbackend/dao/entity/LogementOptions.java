package fr.crepin.microserviceuserbackend.dao.entity;

import fr.crepin.microserviceuserbackend.enums.LogementOptionsEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "microservice", name = "logement_option")
public class LogementOptions {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_logement", nullable = false)
    private Logement logement;

    @Enumerated(EnumType.STRING)
    private LogementOptionsEnum nom;

    public LogementOptions() {
    }

    public LogementOptions(UUID id, Logement logement, LogementOptionsEnum nom) {
        this.id = id;
        this.logement = logement;
        this.nom = nom;
    }

    public LogementOptions(UUID id, LogementOptionsEnum nom) {
        this.id = id;
        this.nom = nom;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public LogementOptionsEnum getNom() {
        return nom;
    }

    public void setNom(LogementOptionsEnum nom) {
        this.nom = nom;
    }
}
