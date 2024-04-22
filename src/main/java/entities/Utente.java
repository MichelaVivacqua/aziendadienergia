package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    private Integer id;
    private String username;
    private String email;
    private int password;
    private String name;
    private String surname;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRuolo(RuoloUtente ruolo) {
        this.ruolo = ruolo;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAvatar() {
        return avatar;
    }

    public RuoloUtente getRuolo() {
        return ruolo;
    }

    private String avatar;
    private RuoloUtente ruolo;

    public Utente(Integer id, String username, String email, int password, String name, String surname, String avatar, RuoloUtente ruolo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.avatar = avatar;
        this.ruolo = ruolo;
    }
}