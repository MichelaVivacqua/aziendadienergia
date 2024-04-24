package team4.aziendadienergia.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Predicate;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;
import team4.aziendadienergia.enums.ClientType;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "VAT")
    private String VATNumber;
    private String email;
    @Column(name = "input_date")
    private LocalDate inputDate;
    @Column(name = "last_contact_date")
    private LocalDate lastContactDate;
    @Column(name = "annual_revenue")
    private long annualRevenue;
    private String pec;
    private String telephone;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_surname")
    private String contactSurname;
    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;
    private String logo;
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    // @JsonIgnore
    // @ToString.Exclude
    // private List<Invoice> invoices;

    @OneToOne
    @JoinColumn(name = "legal_address_id")
    private Address legalAddress;
    @OneToOne
    @JoinColumn(name = "operative_address_id")
    private Address operativeAddress;



    public static Specification<Client> orderByName() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("businessName")));
            return null;
        };
    }

    public static Specification<Client> orderByAnnualRevenue() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("annualRevenue")));
            return null;
        };
    }

    public static Specification<Client> orderByInputDate() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("inputDate")));
            return null;
        };
    }

    public static Specification<Client> orderByLastContactDate() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("lastContactDate")));
            return null;
        };


    }
}