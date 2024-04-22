package team4.aziendadienergia.payloads.clients;

import team4.aziendadienergia.enums.ClientType;

import java.time.LocalDate;

public record NewClientDTO (
     //   @NotEmpty(message = "Business name cannot be empty.")
      //  @Size(min = 7, max = 30, message = "The business name must have a minimum of 7 chars and a maximum of 30.")
        String businessName,
     //   @NotEmpty(message = "VAT number cannot be empty.")
     //  @Size(min = 11, max = 30, message = "The VAT number must have a minimum of 11 chars and a maximum of 11.")
        String VATNumber,
     //   @NotEmpty(message = "Email cannot be empty.")
     //  @Email(message = "Insert a valid email")
        String email,
    // @NotNull(message="The input date is mandatory")
     // @Date(message = "Date format must be: yyyy-mm-dd")
        LocalDate inputDate,
     // @NotNull(message="The last contact  date is mandatory")
     // @Date(message = "Date format must be: yyyy-mm-dd")
        LocalDate lastContactDate,

        // @Min(value=1)
        long annualRevenue,
    // @NotEmpty(message = "Email cannot be empty.")

    // @Email(message = "Insert a valid email")
        String pec,
        // @NotEmpty(message="Telephone contact number cannot be empty")
        String contactPhoneNumber,
     // @NotEmpty(message="Telephone cannot be empty")
        String telephone,
    // @NotEmpty(message = "Email cannot be empty.")
   //  @Email(message = "Insert a valid email")
        String contactEmail,
   //  @NotEmpty(message = "Name cannot be empty.")
    // @Size(min = 3, max = 15, message = "The name must have a minimum of 3 chars and a maximum of 15.")
        String contactName,
    // @NotEmpty(message = "Name cannot be empty.")
    // @Size(min = 3, max = 15, message = "The name must have a minimum of 3 characters and a maximum of 15.")
        String contactSurname,
     //  @NotEmpty(message = "Client type cannot be empty.")
        ClientType clientType






) {
}
