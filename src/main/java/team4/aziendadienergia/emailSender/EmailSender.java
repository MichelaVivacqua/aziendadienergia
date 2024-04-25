package team4.aziendadienergia.emailSender;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import team4.aziendadienergia.entities.Utente;


@Component
public class EmailSender {

    private String apiKey;
    private String domainName;

    public EmailSender(@Value("{mailgun.apiKey}") String apiKey, @Value("{mailgun.domainName}") String domainName){
        this.apiKey=apiKey;
        this.domainName=domainName;
    }

    public void sendRegistrationEmail(Utente recipient){
      HttpResponse<JsonNode> response =  Unirest.post("https://api.mailgun.net/v3/" + this.domainName + "/messsages")
                .basicAuth("api", this.apiKey)
                .queryString("from","wendydeluca96@hotmail.com")
                .queryString("to",recipient.getEmail())
                .queryString("subject", "Succesfully registered!")
                .queryString("text","Thanks" + recipient.getEmail() + "for your registration! ")
                .asJson();
        System.out.println(response);
    }
}
