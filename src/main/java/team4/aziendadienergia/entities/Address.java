package team4.aziendadienergia.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "addresses")
public class Address {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private UUID id;
    private String street;
    private int postal_code;
    private int zip_code;
    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;



}

