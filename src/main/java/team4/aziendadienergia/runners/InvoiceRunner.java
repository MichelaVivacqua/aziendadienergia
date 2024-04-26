//package team4.aziendadienergia.runners;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import team4.aziendadienergia.services.InvoiceService;
//
//import java.time.LocalDate;
//
//@Component
//public class InvoiceRunner implements CommandLineRunner {
//
//    private final InvoiceService invoiceService;
//
//    @Autowired
//    public InvoiceRunner(InvoiceService invoiceService) {
//        this.invoiceService = invoiceService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
        // Test dei metodi di filtro delle fatture

        // Filtraggio per cliente
//        System.out.println("Filtraggio per cliente:");
//        invoiceService.filterByClient(/* inserire UUID del cliente */, 0, 10).forEach(System.out::println);

        // Filtraggio per stato
//        System.out.println("\nFiltraggio per stato:");
//        invoiceService.filterByStatus(/* inserire stato */, 0, 10).forEach(System.out::println);

        // Filtraggio per data
//        System.out.println("\nFiltraggio per data:");
//        invoiceService.filterByDate(LocalDate.now(), 0, 10).forEach(System.out::println);
//
//        // Filtraggio per anno
//        System.out.println("\nFiltraggio per anno:");
//        invoiceService.filterByYear(2023, 0, 10).forEach(System.out::println);
//
//        // Filtraggio per range di importi
//        System.out.println("\nFiltraggio per range di importi:");
//        invoiceService.filterByAmountRange(100.0, 1000.0, 0, 10).forEach(System.out::println);
//    }
//}
