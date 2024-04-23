package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team4.aziendadienergia.entities.Province;

import java.util.UUID;

public interface ProvinceDAO extends JpaRepository<Province, UUID> {
}