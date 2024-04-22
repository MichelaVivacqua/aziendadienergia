package team4.aziendadienergia.payloads.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import team4.aziendadienergia.entities.Client;

import java.util.UUID;

public record ClientResponseDTO (UUID uuid)  {
}
