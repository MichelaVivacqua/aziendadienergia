package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team4.aziendadienergia.entities.Municipality;

import java.util.UUID;

public interface MunicipalityDAO extends JpaRepository<Municipality, UUID> {
}