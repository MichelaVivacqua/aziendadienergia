package team4.aziendadienergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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


}
