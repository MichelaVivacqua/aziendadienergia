package team4.aziendadienergia.services;

import org.springframework.stereotype.Service;
import team4.aziendadienergia.entities.Invoice;
import team4.aziendadienergia.exceptions.NotFoundException;
import team4.aziendadienergia.payloads.invoice.InvoicePayload;
import team4.aziendadienergia.repositories.ClientDAO;
import team4.aziendadienergia.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ClientDAO clientDAO;

//    @Autowired
//    InvoicePayload invoicePayload;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Autowired
    ClientsService clientService;

    public List<Invoice> find() {
        return invoiceRepository.findAll();
    }

    public Page<Invoice> findAll(int page, String sort) {
        Pageable pageable = PageRequest.of(page, 9, Sort.by(sort));
        return invoiceRepository.findAll(pageable);
    }

    public Invoice findById(UUID id) throws NotFoundException {
        return invoiceRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) throws NotFoundException {
        Invoice InvoiceFound = this.findById(id);
        invoiceRepository.delete(InvoiceFound);
    }

    public Invoice findByIdAndUpdate(UUID id, InvoicePayload body) throws NotFoundException {
        Invoice invoiceFound = this.findById(id);
        invoiceFound.setStatus(body.status());
        invoiceFound.setAmount(body.amount());
        return invoiceRepository.save(invoiceFound);
    }

    public Page<Invoice> filterByDate(LocalDate data, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return invoiceRepository.findByDate(data, pageable);
    }

    public Page<Invoice> filterByClient(UUID clientId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return invoiceRepository.findByIdClient(clientId, pageable);
    }

    public Page<Invoice> filterByStatus(String status, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return invoiceRepository.findByStatus(status, pageable);
    }


    public Page<Invoice> filterByYear(int year, int page, int pageSize) {
        LocalDate startOfYear = LocalDate.of(year, 1, 1);
        LocalDate endOfYear = LocalDate.of(year, 12, 31);
        Pageable pageable = PageRequest.of(page, pageSize);
        return invoiceRepository.findByDateBetween(startOfYear, endOfYear, pageable);
    }

    public Page<Invoice> filterByAmountRange(double minAmount, double maxAmount, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return invoiceRepository.findByAmountBetween(minAmount, maxAmount, pageable);
    }
}
