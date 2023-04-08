package fr.crepin.microserviceuserbackend.dao.repository;

import fr.crepin.microserviceuserbackend.dao.entity.Logement;
import fr.crepin.microserviceuserbackend.dao.entity.LogementPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LogementRepository extends JpaRepository<Logement, UUID>
{
    @Query("SELECT l FROM Logement l WHERE l.user.username = :username")
    List<Logement> findByUsername(@Param("username") String username);
}
