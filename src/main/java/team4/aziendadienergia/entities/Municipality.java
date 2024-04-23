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
@Table(name = "municipalities")
public class Municipality {
    @Setter(AccessLevel.NONE)
    @Id
    @Column(name = "municipality_id")
    private long id;
    private String name;
}
