package team4.aziendadienergia.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "provinces")
public class Province {
    @Setter(AccessLevel.NONE)
    @Id
    @Column(name = "province_id")
    private long id;
    private String name;
    private String abbreviation;
}