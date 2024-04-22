package team4.aziendadienergia.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import team4.aziendadienergia.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClientDAO  extends JpaRepository<Client, UUID>, JpaSpecificationExecutor<Client> {
    List<Client> findAll(Specification<Client> spec);
}
