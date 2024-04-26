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
    @ManyToOne
    private Client client;


}