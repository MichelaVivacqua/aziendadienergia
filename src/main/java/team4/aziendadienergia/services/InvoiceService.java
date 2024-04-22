package team4.aziendadienergia.services;

import org.springframework.stereotype.Service;
import team4.aziendadienergia.entities.Invoice;
import team4.aziendadienergia.exceptions.NotFoundException;
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

/*   @Autowired
    ClientService clientService;

    public List<Invoice> find() {
        return InvoiceRepository.findAll();
    }

    public Page<Invoice> findAll(int page, String sort) {
        Pageable pageable = PageRequest.of(page, 9, Sort.by(sort));
        return InvoiceRepository.findAll(pageable);
    }

    public Invoice findById(UUID id) throws NotFoundException {
        return InvoiceRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void findByIdAndDelete(UUID id) throws NotFoundException {
        Invoice InvoiceFound = this.findById(id);
        InvoiceRepository.delete(InvoiceFound);
    }
    public Invoice findByIdAndUpdate(UUID id, InvoicePayload body) throws NotFoundException {
        Invoice InvoiceFound = this.findById(id);
        InvoiceFound.setStatus(body.status());
        InvoiceFound.setAmount(body.amount());
        return InvoiceRepository.save(InvoiceFound);
    }

    public Page<Invoice> filterByData(LocalDate data, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return InvoiceRepository.findByData(data, pageable);
    }*/
}
