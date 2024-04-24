package team4.aziendadienergia.services;


import org.springframework.security.crypto.password.PasswordEncoder;
import team4.aziendadienergia.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team4.aziendadienergia.exceptions.BadRequestException;
import team4.aziendadienergia.exceptions.NotFoundException;
import team4.aziendadienergia.payloads.userAndLogin.NewUtenteDTO;
import team4.aziendadienergia.repositories.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    public  UtenteRepository utenteRepository;

    @Autowired
    public  PasswordEncoder bcrypt;

    public List<Utente> getUtenti(){
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(Integer id){
        Optional<Utente> utenteOptional = utenteRepository.findById(id);
        return utenteOptional.orElse(null);
    }

    public Utente updateUtente(Integer id, Utente updatedUtente) {
        Optional<Utente> existingUtenteOptional = utenteRepository.findById(id);
        if (existingUtenteOptional.isPresent()) {
            Utente existingUtente = existingUtenteOptional.get();

            if (updatedUtente.getName() != null) {
                existingUtente.setName(updatedUtente.getName());
            }
            if (updatedUtente.getSurname() != null) {
                existingUtente.setSurname(updatedUtente.getSurname());
            }
            if (updatedUtente.getEmail() != null) {
                existingUtente.setEmail(updatedUtente.getEmail());
            }

            if (updatedUtente.getAvatar() != null) {
                existingUtente.setAvatar(updatedUtente.getAvatar());
            }

            return utenteRepository.save(existingUtente);
        }
        return null;
    }

//    public Utente createUtente(Utente newUtente){
//        return utenteRepository.save(newUtente);
//    }

    public Utente createUtente(NewUtenteDTO newUtenteDTO) {

        if (utenteRepository.existsByEmail(newUtenteDTO.email())) {
            throw new BadRequestException("L'email " + newUtenteDTO.email() + " è già in uso, quindi l'utente ha già un account! Contatta l'assistenza se hai dimenticato la tua password");
        }

        Utente utente = new Utente(newUtenteDTO.username(), newUtenteDTO.email(), bcrypt.encode(newUtenteDTO.password()),newUtenteDTO.name(), newUtenteDTO.surname(), newUtenteDTO.avatar(),newUtenteDTO.ruolo());
//        System.out.println(utente);
        return utenteRepository.save(utente);
    }

    public void deleteUtente(Integer id){
        utenteRepository.deleteById(id);
    }

    public Utente findByEmail(String email) {
        return utenteRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovato!"));
    }
}
