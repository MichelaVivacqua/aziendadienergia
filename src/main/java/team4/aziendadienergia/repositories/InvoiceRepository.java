package team4.aziendadienergia.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import team4.aziendadienergia.entities.Invoice;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository <Invoice, UUID> {

    Page<Invoice> findByIdClient(UUID client, Pageable pageable);
    Page<Invoice> findByStatus(String status, Pageable pageable);
    Page<Invoice> findByDate(LocalDate date, Pageable pageable);
    Page<Invoice> findByAmountBetween(double minAmount, double maxAmount, Pageable pageable);

}
