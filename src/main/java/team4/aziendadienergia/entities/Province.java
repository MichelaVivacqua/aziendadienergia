package team4.aziendadienergia.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

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
    private String nome;
    private String codiceProvincia;
    private String region;
    @OneToMany(mappedBy = "province")
    @JsonIgnore
    @ToStringExclude
    private List<Municipality> municipality;
}