package controllers;

import UtenteService.UtenteService;
import entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    UtenteService utenteService;
    @GetMapping
    public List<Utente> getUtenti(){
        return utenteService.getUtenti();
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable int id){
        return utenteService.getUtenteById(id);
    }

    @PostMapping
    public Utente createUtente(@RequestBody Utente utente){
        return utenteService.createUtente(utente);
    }

    @PutMapping("/{id}")
    public Utente updateUtente(@PathVariable int id, @RequestBody Utente utente){
        return utenteService.updateUtente(id, utente);
    }

    @DeleteMapping("/{id}")
    public void
    deleteUtente(@PathVariable int id){
        utenteService.deleteUtente(id);
    }
}
