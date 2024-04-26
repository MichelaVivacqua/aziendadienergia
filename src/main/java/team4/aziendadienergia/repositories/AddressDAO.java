package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team4.aziendadienergia.entities.Address;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressDAO extends JpaRepository<Address, UUID> {
//    Optional<Address> findById(String id);
}