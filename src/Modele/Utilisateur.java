package Modele;

public class Utilisateur {
    protected String userMdp;
    protected String userMail;

    public Utilisateur (String userMdp, String userMail) {
        this.userMdp = userMdp;
        this.userMail = userMail;
    }

    public void ajouterReservation() {}
    public void supprimerReservation() {}
    public void afficherReservation() {}
    public void modifierReservation() {}
}