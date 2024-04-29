package team4.aziendadienergia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team4.aziendadienergia.entities.Address;
import team4.aziendadienergia.entities.Client;
import team4.aziendadienergia.payloads.clients.NewClientDTO;
import team4.aziendadienergia.services.ClientsService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientsService clientsService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Client> findAllClients(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10")int size,
                                       @RequestParam(defaultValue = "name")String sortBy){

        return clientsService.findAllClients(page,size,sortBy);

    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Client saveClient(NewClientDTO body){
        return clientsService.saveClient(body);

    }


    @GetMapping("/{clientId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Client findById(@PathVariable UUID clientId){
        return clientsService.findById(clientId);
    }


    @PutMapping("/{clientId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Client findByIdAndUpdate(@PathVariable UUID clientId, @RequestBody NewClientDTO body){

        return clientsService.saveClient(body);
    }

    @PutMapping("/{clientId}/updatesedeoperativa")
    public Client findByIdAndUpdateSedeOperativa(@PathVariable UUID clientId, @RequestBody Address newAddress) {
        Client client = clientsService.findById(clientId);
        return clientsService.findByIdAndUpdateSedeOperativa(clientId, newAddress);
    }

    @PutMapping("/{clientId}/updatesedelegale")
    public Client findByIdAndUpdateSedeLegale(@PathVariable UUID clientId, @RequestBody Address newAddress) {
        Client client = clientsService.findById(clientId);
        return clientsService.findByIdAndUpdateSedeLegale(clientId, newAddress);
    }

    @PutMapping("/{clientId}/updateragionesociale")
    public Client findByIdAndUpdateRagioneSociale(@PathVariable UUID clientId, @RequestBody String newRagioneSociale) {
        return clientsService.updateRagioneSociale(clientId, newRagioneSociale);
    }

    @PutMapping("/{clientId}/updatevatnumber")
    public Client findByIdAndUpdateVATNumber(@PathVariable UUID clientId, @RequestBody String newVATNumber) {
        return clientsService.updateVATNumber(clientId, newVATNumber);
    }

    @PutMapping("/{clientId}/updateannualrevenue")
    public Client findByIdAndUpdateAnnualRevenue(@PathVariable UUID clientId, @RequestBody long newAnnualRevenue) {
        return clientsService.updateAnnualRevenue(clientId, newAnnualRevenue);
    }

    @PutMapping("/{clientId}/updatepec")
    public Client findByIdAndUpdatePEC(@PathVariable UUID clientId, @RequestBody String newPEC) {
        return clientsService.updatePEC(clientId, newPEC);
    }

    @PutMapping("/{clientId}/updatephone")
    public Client findByIdAndUpdatePhone(@PathVariable UUID clientId, @RequestBody String newPhoneNumber) {
        return clientsService.updatePhone(clientId, newPhoneNumber);
    }

    @PutMapping("/{clientId}/updateemail")
    public Client findByIdAndUpdateEmail(@PathVariable UUID clientId, @RequestBody String newEmail) {
        return clientsService.updateEmail(clientId, newEmail);
    }

    @PutMapping("/{clientId}/updatename")
    public Client findByIdAndUpdateName(@PathVariable UUID clientId, @RequestBody String newName) {
        return clientsService.updateName(clientId, newName);
    }

    @PutMapping("/{clientId}/updatesurname")
    public Client findByIdAndUpdateSurname(@PathVariable UUID clientId, @RequestBody String newSurname) {
        return clientsService.updateSurname(clientId, newSurname);
    }


    @DeleteMapping("/{clientId}/deletelegaladdress")
    public Client deleteLegalAddress(@RequestParam UUID clientId) {
        return clientsService.deleteLegalAddress(clientId);
    }

    @DeleteMapping("/{clientId}/deleteoperativeadress")
    public Client deleteOperativeAddress(@RequestParam UUID clientId) {
        return clientsService.deleteOperativeAddress(clientId);
    }

    @DeleteMapping("/{clientId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteClient(@PathVariable UUID clientId){
         clientsService.deleteClient(clientId);
    }

    @GetMapping("/by-annual-revenue")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Client>> getClientsByAnnualRevenue(
            @RequestParam("minRevenue") long minRevenue,
            @RequestParam("maxRevenue") long maxRevenue) {
        List<Client> clients = clientsService.getClientsByAnnualRevenue(minRevenue, maxRevenue);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/by-input-date")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Client>> getClientsByInputDate(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Client> clients = clientsService.getClientsByInputDate(start, end);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/by-last-contact-date")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Client>> getClientsByLastContactDate(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Client> clients = clientsService.getClientsByLastContactDate(start, end);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/by-name")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Client>> getClientsByNameContains(
            @RequestParam("namePart") String namePart) {
        List<Client> clients = clientsService.getClientsByNameContains(namePart);
        return ResponseEntity.ok(clients);
    }




}
