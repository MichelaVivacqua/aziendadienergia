package team4.aziendadienergia.repositories;

import team4.aziendadienergia.entities.Utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    boolean existsByEmail(String email);
    Optional<Utente> findByEmail(String nome);
}
