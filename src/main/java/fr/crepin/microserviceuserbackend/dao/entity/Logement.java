package fr.crepin.microserviceuserbackend.dao.entity;

import fr.crepin.microserviceuserbackend.dto.logement.LogementPhotosDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "microservice", name = "logement")
public class Logement {
    @Id
    @GeneratedValue
    private UUID id;
    private String titre;

    @Column(name = "nbr_piece")
    private int nombrePieces;
    private float taille;

    @Column(name = "nbr_etage")
    private int nombreEtages;

    private int prix;
    private String description;

    @OneToMany(targetEntity = LogementPhotos.class, mappedBy = "logement", cascade = CascadeType.ALL)
    private List<LogementPhotos> logementPhotos;

    @OneToMany(targetEntity = LogementOptions.class, mappedBy = "logement", cascade = CascadeType.ALL)
    private List<LogementOptions> logementOptions;

    public Logement() {
        logementPhotos = new ArrayList<>();
        logementOptions = new ArrayList<>();
    }

    public Logement(String titre, int nombrePieces, float taille, int nombreEtages, int prix, String description, List<LogementPhotos> role) {
        this.titre = titre;
        this.nombrePieces = nombrePieces;
        this.taille = taille;
        this.nombreEtages = nombreEtages;
        this.prix = prix;
        this.description = description;
        this.logementPhotos = role;
    }

    public Logement(UUID id, String titre, int nombrePieces, float taille, int nombreEtages, int prix, String description, List<LogementPhotos> role) {
        this.id = id;
        this.titre = titre;
        this.nombrePieces = nombrePieces;
        this.taille = taille;
        this.nombreEtages = nombreEtages;
        this.prix = prix;
        this.description = description;
        this.logementPhotos = role;
    }

    public void addPhoto(LogementPhotos photo){
        photo.setLogement(this);
        logementPhotos.add(photo);
    }

    public void addOption(LogementOptions options){
        options.setLogement(this);
        logementOptions.add(options);
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(int nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public int getNombreEtages() {
        return nombreEtages;
    }

    public void setNombreEtages(int nombreEtages) {
        this.nombreEtages = nombreEtages;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LogementPhotos> getLogementPhotos() {
        return logementPhotos;
    }

    public void setLogementPhotos(List<LogementPhotos> role) {
        this.logementPhotos = role;
    }

    public List<LogementOptions> getLogementOptions() {
        return logementOptions;
    }

    public void setLogementOptions(List<LogementOptions> logementOptions) {
        this.logementOptions = logementOptions;
    }
}
