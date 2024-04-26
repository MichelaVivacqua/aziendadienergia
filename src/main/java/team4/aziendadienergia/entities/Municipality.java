package team4.aziendadienergia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringExclude;

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
    private String postalCode;
    private String name;
    private String provinceCity;
    @OneToMany(mappedBy = "municipality")
    @JsonIgnore
    @ToStringExclude
    private List<Address> address;
    @ManyToOne
    @JoinColumn(name = "province_nome")
    private Province province;
    //

}