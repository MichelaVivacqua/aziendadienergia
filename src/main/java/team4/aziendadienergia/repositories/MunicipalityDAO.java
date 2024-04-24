package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team4.aziendadienergia.entities.Municipality;

import java.util.UUID;

@Repository
public interface MunicipalityDAO extends JpaRepository<Municipality, UUID> {
}