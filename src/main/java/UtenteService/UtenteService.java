package UtenteService;


import entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

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

    public Utente createUtente(Utente newUtente){
        return utenteRepository.save(newUtente);
    }

    public void deleteUtente(Integer id){
        utenteRepository.deleteById(id);
    }
}
