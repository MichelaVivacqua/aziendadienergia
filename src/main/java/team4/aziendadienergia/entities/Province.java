package team4.aziendadienergia.entities;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "provinces")
public class Province {
    @Setter
    @Id
    @Column(name = "nomeProvincia")
    private String nome;
    private String codiceProvincia;
    private String region;
    @OneToMany(mappedBy = "province")
    private List<Municipality> municipality;
}