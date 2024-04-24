package team4.aziendadienergia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team4.aziendadienergia.entities.Utente;
import team4.aziendadienergia.exceptions.UnauthorizedException;
import team4.aziendadienergia.payloads.userAndLogin.UserLoginDTO;
import team4.aziendadienergia.security.JWTTools;

@Service
public class AuthService {
    @Autowired
    public UtenteService utentiService;

    @Autowired
    public JWTTools jwtTools;

    @Autowired
    public PasswordEncoder bcrypt;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload){

        Utente utente = this.utentiService.findByEmail(payload.email());
        // Verifico se la password combacia con quella ricevuta nel payload
        if (bcrypt.matches(payload.password(), utente.getPassword())) {
            // Genero un token e lo torno
            return jwtTools.createToken(utente);
        } else {
            throw new UnauthorizedException("Credenziali non valide! Impossibile accedere");
        }


    }
}
