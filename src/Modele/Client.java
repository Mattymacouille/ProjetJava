package Modele;

import java.time.LocalDate;

public class Client extends Utilisateur {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    public Client(int id, String nom, String prenom, LocalDate dateNaissance) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
