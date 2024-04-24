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
    @Setter
    @Id
    @Column(name = "codiceProvincia")
    private String codiceProvincia;
    private String name;
    private String region;
}