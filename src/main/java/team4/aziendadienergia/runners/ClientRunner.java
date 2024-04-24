package team4.aziendadienergia.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import team4.aziendadienergia.entities.Client;
import team4.aziendadienergia.services.ClientsService;

import java.time.LocalDate;
import java.util.List;

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

        System.out.println("\nClienti ordinati per provincia della sede legale:");
        clientService.getAllClientsOrderedByProvince().forEach(System.out::println);


        // Test dei metodi di filtro
        System.out.println("\nClienti con fatturato annuale compreso tra 10000 e 50000:");
        List<Client> clientsByRevenue = clientService.getClientsByAnnualRevenue(10000, 50000);
        clientsByRevenue.forEach(System.out::println);

        System.out.println("\nClienti inseriti tra il 2023-01-01 e il 2023-12-31:");
        List<Client> clientsByInputDate = clientService.getClientsByInputDate(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );
        clientsByInputDate.forEach(System.out::println);

        System.out.println("\nClienti con ultimo contatto tra il 2023-01-01 e il 2023-12-31:");
        List<Client> clientsByLastContactDate = clientService.getClientsByLastContactDate(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );
        clientsByLastContactDate.forEach(System.out::println);

        System.out.println("\nClienti con parte del nome 'example':");
        List<Client> clientsByNameContains = clientService.getClientsByNameContains("example");
        clientsByNameContains.forEach(System.out::println);
    }
    }

