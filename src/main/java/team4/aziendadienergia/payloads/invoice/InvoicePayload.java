package team4.aziendadienergia.payloads.invoice;

import java.time.LocalDate;
import java.util.UUID;

public record InvoicePayload(UUID id, int year, LocalDate date, double amount, UUID idClient, String status) {
}
