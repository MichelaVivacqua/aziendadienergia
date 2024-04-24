package team4.aziendadienergia.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "municipalities")
public class Municipality {
    @Setter
    @Id
    @Column(name = "municipality_id")
    private String postalCode;
    private String name;
    private String provinceCity;
    @OneToMany(mappedBy = "municipality")
    private List<Address> address;
    @ManyToOne
    @JoinColumn(name = "province_nome")
    private List<Province> province;

}