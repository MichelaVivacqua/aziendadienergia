package team4.aziendadienergia.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team4.aziendadienergia.entities.Address;
import team4.aziendadienergia.exceptions.NotFoundException;
import team4.aziendadienergia.payloads.address.NewAddressDTO;
import team4.aziendadienergia.repositories.AddressDAO;


@Service
public class AddressService {


    @Autowired
    public AddressDAO addressDAO;



    public Page<Address> getAddress(int page, int size, String sort){
        if (size > 40) size = 40;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return addressDAO.findAll(pageable);
    }

//    public Address findById(UUID id) throws NotFoundException {
//        Optional<Address> address = addressDAO.findById(String.valueOf(id));
//        if (address.isEmpty()) {
//            throw new NotFoundException(id);
//        }
//        return address.get();
//    }

    public Address findByIdAndUpdate(UUID id, NewAddressDTO body){
        Address address = new Address();
        address.setStreet(body.street());
        address.setPostal_code(body.postal_code());
        address.setZip_code(body.zip_code());
        return addressDAO.save(address);
    }

//        public void findByIdAndDelete(UUID id){
//        Address address = this.findById(id);
//        addressDAO.delete(address);
//    }




}
