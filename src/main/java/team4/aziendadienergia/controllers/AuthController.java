package team4.aziendadienergia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team4.aziendadienergia.exceptions.BadRequestException;
import team4.aziendadienergia.payloads.userAndLogin.NewUtenteDTO;
import team4.aziendadienergia.payloads.userAndLogin.NewUtenteRespDTO;
import team4.aziendadienergia.payloads.userAndLogin.UserLoginDTO;
import team4.aziendadienergia.payloads.userAndLogin.UserLoginRespDTO;
import team4.aziendadienergia.services.AuthService;
import team4.aziendadienergia.services.UtenteService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UtenteService utentiService;

    //    POST http://localhost:3001/auth/login
    @PostMapping("/login")
    public UserLoginRespDTO login(@RequestBody UserLoginDTO payload){
        return new UserLoginRespDTO(this.authService.authenticateUserAndGenerateToken(payload));
    }

    //    POST http://localhost:3001/auth/register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUtenteRespDTO saveUser(@RequestBody @Validated NewUtenteDTO body, BindingResult validation){
        if(validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return new NewUtenteRespDTO(this.utentiService.createUtente(body).getId());
    }

}
