package team4.aziendadienergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team4.aziendadienergia.entities.Address;
import team4.aziendadienergia.entities.Client;
import team4.aziendadienergia.enums.ClientType;
import team4.aziendadienergia.exceptions.NotFoundException;
import team4.aziendadienergia.payloads.clients.NewClientDTO;
import team4.aziendadienergia.repositories.ClientDAO;

import java.util.List;
import java.util.UUID;

@Service
public class ClientsService {

    @Autowired
    public ClientDAO clientDAO;

    @Autowired
    public ClientsService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Page<Client> findAllClients(int page, int size, String sortBy){
       if (size < 50) size = 50;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return clientDAO.findAll(pageable);
    }

    public Client findById(UUID clientId){
        return clientDAO.findById(clientId).orElseThrow(()-> new NotFoundException(clientId));

    }


    public Client saveClient( NewClientDTO body){
        Client client = new Client();
        client.setBusinessName(body.businessName());
        client.setVATNumber(body.VATNumber());
        client.setEmail(body.email());
        client.setInputDate(body.inputDate());
        client.setLastContactDate(body.lastContactDate());
        client.setAnnualRevenue(body.annualRevenue());
        client.setPec(body.pec());
        client.setContactPhoneNumber(body.contactPhoneNumber());
        client.setTelephone(body.telephone());
        client.setContactEmail(body.contactEmail());
        client.setContactName(body.contactName());
        client.setContactSurname(body.contactSurname());
        client.setClientType(ClientType.valueOf(String.valueOf(body.clientType())));
        return clientDAO.save(client);
    }

    public Client findByIdAndUpdateSedeOperativa(UUID clientId, Address newAddress) {
        Client client = this.findById(clientId);
        client.setOperativeAddress(newAddress);
        return clientDAO.save(client);
    }

    public Client findByIdAndUpdateSedeLegale(UUID clientId, Address newAddress) {
        Client client = this.findById(clientId);
        client.setLegalAddress(newAddress);
        return clientDAO.save(client);
    }

    public Client findByIdAndUpdate(UUID clientId, NewClientDTO body){
        Client found = this.findById(clientId);
        found.setBusinessName(body.businessName());
        found.setClientType(body.clientType());
        found.setEmail(body.email());
        found.setContactName(body.contactName());
        found.setContactSurname(body.contactSurname());
        found.setContactPhoneNumber(body.contactPhoneNumber());
        return clientDAO.save(found);

    }

    public void deleteClient(UUID clientId){
        Client found = this.findById(clientId);
        clientDAO.delete(found);
    }

//    public List<Client> getAllClientsOrderedByProvince() {
//        return clientDAO.findAll(Client.orderByProvince());
//    }

    public List<Client> getClientsOrderedByName() {
        return clientDAO.findAll(Client.orderByName());
    }

    public List<Client> getClientsOrderedByAnnualRevenue() {
        return clientDAO.findAll(Client.orderByAnnualRevenue());
    }

    public List<Client> getClientsOrderedByInputDate() {
        return clientDAO.findAll(Client.orderByInputDate());
    }

    public List<Client> getClientsOrderedByLastContactDate() {
        return clientDAO.findAll(Client.orderByLastContactDate());
    }

    public Client updateRagioneSociale(UUID clientId, String newRagioneSociale) {
        Client client = this.findById(clientId);
        client.setBusinessName(newRagioneSociale);
        return clientDAO.save(client);
    }

    public Client updateVATNumber(UUID clientId, String newVATNumber) {
        Client client = this.findById(clientId);
        client.setVATNumber(newVATNumber);
        return clientDAO.save(client);
    }

    public Client updateAnnualRevenue(UUID clientId, long newAnnualRevenue) {
        Client client = this.findById(clientId);
        client.setAnnualRevenue(newAnnualRevenue);
        return clientDAO.save(client);
    }

    public Client updatePEC(UUID clientId, String newPEC) {
        Client client = this.findById(clientId);
        client.setPec(newPEC);
        return clientDAO.save(client);
    }

    public Client updatePhone(UUID clientId, String newPhoneNumber) {
        Client client = this.findById(clientId);
        client.setTelephone(newPhoneNumber);
        return clientDAO.save(client);
    }

    public Client deleteOperativeAddress(UUID clientId) {
        Client client = this.findById(clientId);
        client.setOperativeAddress(null);
        return clientDAO.save(client);
    }

    public Client updateEmail(UUID clientId, String newEmail) {
        Client client = this.findById(clientId);
        client.setEmail(newEmail);
        return clientDAO.save(client);
    }

    public Client deleteLegalAddress(UUID clientId) {
        Client client = this.findById(clientId);
        client.setLegalAddress(null);
        return clientDAO.save(client);
    }

    public Client updateName(UUID clientId, String newName) {
        Client client = this.findById(clientId);
        client.setBusinessName(newName);
        return clientDAO.save(client);
    }

    public Client updateSurname(UUID clientId, String newSurname) {
        Client client = this.findById(clientId);
        client.setContactSurname(newSurname);
        return clientDAO.save(client);
    }
}
