package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team4.aziendadienergia.entities.Address;

import java.util.Optional;
@Repository
public interface AddressDAO extends JpaRepository<Address, String> {
    Optional<Address> findById(String id);
}