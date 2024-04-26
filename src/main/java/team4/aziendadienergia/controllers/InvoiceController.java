package team4.aziendadienergia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team4.aziendadienergia.entities.Invoice;
import team4.aziendadienergia.services.InvoiceService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    public InvoiceService invoiceService;

//    @GetMapping("/by-client")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<Page<Invoice>> getInvoicesByClient(
//            @RequestParam("clientId") UUID clientId,
//            @RequestParam("page") int page,
//            @RequestParam("pageSize") int pageSize) {
//        Page<Invoice> invoices = invoiceService.filterByClient(clientId, page, pageSize);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @GetMapping("/by-status")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<Page<Invoice>> getInvoicesByStatus(
//            @RequestParam("status") String status,
//            @RequestParam("page") int page,
//            @RequestParam("pageSize") int pageSize) {
//        Page<Invoice> invoices = invoiceService.filterByStatus(status, page, pageSize);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @GetMapping("/by-date")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<Page<Invoice>> getInvoicesByDate(
//            @RequestParam("date") String date,
//            @RequestParam("page") int page,
//            @RequestParam("pageSize") int pageSize) {
//        LocalDate parsedDate = LocalDate.parse(date);
//        Page<Invoice> invoices = invoiceService.filterByDate(parsedDate, page, pageSize);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @GetMapping("/by-year")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<Page<Invoice>> getInvoicesByYear(
//            @RequestParam("year") int year,
//            @RequestParam("page") int page,
//            @RequestParam("pageSize") int pageSize) {
//        Page<Invoice> invoices = invoiceService.filterByYear(year, page, pageSize);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @GetMapping("/by-amount-range")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<Page<Invoice>> getInvoicesByAmountRange(
//            @RequestParam("minAmount") double minAmount,
//            @RequestParam("maxAmount") double maxAmount,
//            @RequestParam("page") int page,
//            @RequestParam("pageSize") int pageSize) {
//        Page<Invoice> invoices = invoiceService.filterByAmountRange(minAmount, maxAmount, page, pageSize);
//        return ResponseEntity.ok(invoices);
//    }
}
