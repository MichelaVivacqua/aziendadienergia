package team4.aziendadienergia.payloads.address;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record NewAddressDTO(@NotEmpty(message = "The street is mandatory")
                              String street,
                              @NotNull(message = "The postal code is mandatory")
                              int postal_code,
                              @NotNull(message = "The zip code is mandatory ")
                              int zip_code,
                              @NotNull(message = "The municipality is mandatory")
                              UUID municipality_id) {

}
