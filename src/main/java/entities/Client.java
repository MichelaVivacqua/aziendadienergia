package entities;

import jakarta.persistence.*;
import lombok.*;

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

//    private Address legalAddress;
//    private Address operativeAddress;




}
