package Modele;

import java.time.LocalDate;

public class Admin extends Utilisateur {

    public Admin(int id) {
        super(id);
    }

    public Admin(int id, String userMdp, String userMail) {
        super(id, userMdp, userMail);
    }

    // Accès aux infos client (facultatif)
    public String getNom(Client client) {
        return client.getNom();
    }

    public String getPrenom(Client client) {
        return client.getPrenom();
    }

    public LocalDate getDateNaissance(Client client) {
        return client.getDateNaissance();
    }

    public void setNom(Client client, String nom) {
        client.setNom(nom);
    }

    public void setPrenom(Client client, String prenom) {
        client.setPrenom(prenom);
    }

    public void setDateNaissance(Client client, LocalDate dateNaissance) {
        client.setDateNaissance(dateNaissance);
    }
}
