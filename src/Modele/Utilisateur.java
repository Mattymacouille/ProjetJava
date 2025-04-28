package Modele;

public class Utilisateur {
    protected String userMdp;
    protected String userMail;

    public Utilisateur (String userMdp, String userMail) {
        this.userMdp = userMdp;
        this.userMail = userMail;
    }
}