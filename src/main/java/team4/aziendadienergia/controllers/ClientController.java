package team4.aziendadienergia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team4.aziendadienergia.entities.Client;
import team4.aziendadienergia.payloads.clients.NewClientDTO;
import team4.aziendadienergia.services.ClientsService;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientsService clientsService;

    @GetMapping
//    @PreAuthorize("hasAuthority('ADMIN)")
    public Page<Client> findAllClients(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10")int size,
                                       @RequestParam(defaultValue = "name")String sortBy){

        return clientsService.findAllClients(page,size,sortBy);

    }

    @GetMapping("/{clientId}")
//    @PreAuthorize("hasAuthority('ADMIN)")
    public Client findById(@PathVariable UUID clientId){
        return clientsService.findById(clientId);
    }


    @PutMapping("/{clientId}")
//    @PreAuthorize("hasAuthority('ADMIN)")
    public Client findByIdAndUpdate(@PathVariable UUID clientId, @RequestBody NewClientDTO body){
        return clientsService.saveClient(body);
    }

    @DeleteMapping("/{clientId}")
//    @PreAuthorize("hasAuthority('ADMIN)")
    public void deleteClient(@PathVariable UUID clientId){
         clientsService.deleteClient(clientId);
    }




}
