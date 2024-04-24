package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import team4.aziendadienergia.entities.Address;

import java.util.Optional;

public interface AddressDAO extends JpaRepository<Address, String> {
    Optional<Address> findById(String id);
}