package team4.aziendadienergia.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.AccessLevel;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long id;
    private String street;
    private int postal_code;
    private int cap;
    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    public Address(int postal_code, String street, int cap, Municipality municipality) {
        this.postal_code = postal_code;
        this.street = street;
        this.cap = cap;
        this.municipality = municipality;
    }
}

