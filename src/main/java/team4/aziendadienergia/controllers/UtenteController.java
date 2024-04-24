package team4.aziendadienergia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import team4.aziendadienergia.exceptions.BadRequestException;
import team4.aziendadienergia.payloads.userAndLogin.NewUtenteDTO;
import team4.aziendadienergia.payloads.userAndLogin.NewUtenteRespDTO;
import team4.aziendadienergia.services.UtenteService;
import team4.aziendadienergia.entities.Utente;
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

//    @PostMapping
//    public Utente createUtente(@RequestBody Utente utente){
//        return utenteService.createUtente(utente);
//    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUtenteRespDTO saveUtente(@RequestBody @Validated NewUtenteDTO body, BindingResult validation){

        if(validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException(validation.getAllErrors());
        }
        System.out.println(body);
        return new NewUtenteRespDTO(this.utenteService.createUtente(body).getId());}

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Utente updateUtente(@PathVariable int id, @RequestBody Utente utente){
        return utenteService.updateUtente(id, utente);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void
    deleteUtente(@PathVariable int id){
        utenteService.deleteUtente(id);
    }
}
