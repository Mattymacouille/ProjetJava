package Modele;

import java.time.LocalDate;

public class Admin extends Utilisateur{
    public Admin(String userMdp, String userMail) {
        super(userMdp, userMail);
    }

    public String getNom(Client client) {return client.getNom();}
    public String getPrenom(Client client) {return client.getPrenom();}
    public LocalDate getDateNaissance(Client client) {return client.getDateNaissance();}
    public int getClientId(Client client) {return client.getClientId();}

    public void setNom(Client client, String nom) {client.setNom(nom);}
    public void setPrenom(Client client, String prenom) {client.setPrenom(prenom);}
    public void setDateNaissance(Client client, LocalDate dateNaissance) {client.setDateNaissance(dateNaissance);}
    public void setClientId(Client client, int clientId) {client.setClientId(clientId);}
}
