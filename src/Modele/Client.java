package Modele;

import java.time.LocalDate;

public class Client extends Utilisateur{
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int clientId;

    public Client(String userMdp, String userMail, String nom, String prenom, LocalDate dateNaissance, int clientId) {
        super(userMdp, userMail);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.clientId = clientId;
    }

    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public LocalDate getDateNaissance() {return dateNaissance;}
    public int getClientId() {return clientId;}

    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setDateNaissance(LocalDate dateNaissance) {this.dateNaissance = dateNaissance;}
}
