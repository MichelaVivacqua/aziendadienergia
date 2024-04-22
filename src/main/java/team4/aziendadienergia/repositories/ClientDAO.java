package team4.aziendadienergia.repositories;

import team4.aziendadienergia.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClientDAO  extends JpaRepository<Client, UUID> {
}
