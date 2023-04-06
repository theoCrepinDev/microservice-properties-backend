package fr.crepin.microserviceuserbackend.dao.repository;

import fr.crepin.microserviceuserbackend.dao.entity.LogementOptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogementOptionsRepository extends JpaRepository<LogementOptions, UUID> {
}
