package team4.aziendadienergia.entities;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Invoice {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;
    private double amount;
    private double number;
    private String status;
//    @ManyToOne
//    @JoinColumn(name = "invoice_id")
//    private Client client;
@ManyToOne
@JoinColumn(name = "client_id") // Usa il nome della colonna corretto che rappresenta l'identificatore del cliente
private Client client;


}