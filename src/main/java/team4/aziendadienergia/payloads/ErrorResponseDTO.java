package team4.aziendadienergia.payloads;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorResponseDTO(String message, LocalDateTime timestamp) {
}
