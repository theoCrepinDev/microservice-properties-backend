package fr.crepin.microserviceuserbackend.dao.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@ Entity
@Table(schema = "microservice", name = "logement_photos")
public class LogementPhotos {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_logement", nullable = false)
    private Logement logement;
    private int position;

    private String lien;

    public LogementPhotos(UUID id, Logement logement, int position) {
        this.id = id;
        this.logement = logement;
        this.position = position;
    }

    public LogementPhotos(Logement logement, int position) {
        this.logement = logement;
        this.position = position;
    }

    public LogementPhotos() {

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}
