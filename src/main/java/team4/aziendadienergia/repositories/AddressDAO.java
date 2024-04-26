package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team4.aziendadienergia.entities.Address;

import java.util.List;

@Repository
public interface AddressDAO extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a JOIN FETCH a.municipality m JOIN FETCH a.province p WHERE a.id = ?1")
    Address findAddressByIdWithDetails(Long id);

    @Query("SELECT a FROM Address a JOIN FETCH a.municipality m JOIN FETCH a.province p")
    List<Address> findAllAddressesWithDetails();
}
