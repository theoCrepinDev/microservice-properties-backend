package fr.crepin.microserviceuserbackend.dao.repository;

import fr.crepin.microserviceuserbackend.dao.entity.LogementPhotos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogementPhotosRepository extends JpaRepository<LogementPhotos, UUID> {
}
