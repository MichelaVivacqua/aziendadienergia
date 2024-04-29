package team4.aziendadienergia.emailSender;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import team4.aziendadienergia.entities.Client;



@Component
public class EmailSender {

    private String apiKey;
    private String domainName;

    public EmailSender(@Value("{mailgun.apikey}") String apiKey, @Value("{mailgun.domainname}") String domainName){
        this.apiKey=apiKey;
        this.domainName=domainName;
    }

    public void sendRegistrationEmail(Client recipient){
      HttpResponse<JsonNode> response =  Unirest.post("https://api.mailgun.net/v3/" + this.domainName + "/messages")
                .basicAuth("api", this.apiKey)
                .queryString("from","wendydeluca96@hotmail.com")
                .queryString("to",recipient.getEmail())
                .queryString("subject", "Successfully registered!")
                .queryString("text","Thanks" + recipient.getEmail() + "for your registration! ")
                .asJson();
        System.out.println(response);
    }
}
