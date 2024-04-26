package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team4.aziendadienergia.entities.Province;

import java.util.UUID;
@Repository
public interface ProvinceDAO extends JpaRepository<Province, String> {
}