package team4.aziendadienergia.entities;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id")
    private UUID id;
    private LocalDate date;
    private double amount;
    private double number;
    private String status;
    private UUID idCliente;

    public Invoice(LocalDate date, double amount, double number, String status, UUID idCliente) {
        this.date = date;
        this.amount = amount;
        this.number = number;
        this.status = status;
        this.idCliente = idCliente;
    }

}