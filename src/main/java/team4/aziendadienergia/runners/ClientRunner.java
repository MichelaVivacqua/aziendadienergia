package team4.aziendadienergia.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import team4.aziendadienergia.services.ClientsService;

@Component
public class ClientRunner implements CommandLineRunner {

    private final ClientsService clientService;

    @Autowired
    public ClientRunner(ClientsService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Test dei metodi di ordinamento
        System.out.println("Clienti ordinati per nome:");
        clientService.getClientsOrderedByName().forEach(System.out::println);

        System.out.println("\nClienti ordinati per fatturato annuale:");
        clientService.getClientsOrderedByAnnualRevenue().forEach(System.out::println);

        System.out.println("\nClienti ordinati per data di inserimento:");
        clientService.getClientsOrderedByInputDate().forEach(System.out::println);

        System.out.println("\nClienti ordinati per data di ultimo contatto:");
        clientService.getClientsOrderedByLastContactDate().forEach(System.out::println);

//        System.out.println("\nClienti ordinati per provincia della sede legale:");
//        clientService.getAllClientsOrderedByProvince().forEach(System.out::println);
    }
}
