package team4.aziendadienergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import team4.aziendadienergia.entities.Client;
import team4.aziendadienergia.enums.ClientType;
import team4.aziendadienergia.exceptions.NotFoundException;
import team4.aziendadienergia.payloads.clients.NewClientDTO;
import team4.aziendadienergia.repositories.ClientDAO;

import java.time.LocalDate;
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

//    Filtraggio per Fatturato Annuale:
public List<Client> getClientsByAnnualRevenue(long minRevenue, long maxRevenue) {
    Specification<Client> spec = (root, query, criteriaBuilder) ->
            criteriaBuilder.between(root.get("annualRevenue"), minRevenue, maxRevenue);
    return clientDAO.findAll(spec);
}

//    Filtraggio per Data di Inserimento:
public List<Client> getClientsByInputDate(LocalDate startDate, LocalDate endDate) {
    Specification<Client> spec = (root, query, criteriaBuilder) ->
            criteriaBuilder.between(root.get("inputDate"), startDate, endDate);
    return clientDAO.findAll(spec);
}

//    Filtraggio per Data di Ultimo Contatto:
public List<Client> getClientsByLastContactDate(LocalDate startDate, LocalDate endDate) {
    Specification<Client> spec = (root, query, criteriaBuilder) ->
            criteriaBuilder.between(root.get("lastContactDate"), startDate, endDate);
    return clientDAO.findAll(spec);
}
//    Filtraggio per Parte del Nome:
public List<Client> getClientsByNameContains(String namePart) {
    Specification<Client> spec = (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("businessName"), "%" + namePart + "%");
    return clientDAO.findAll(spec);
}

}
