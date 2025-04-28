package Modele;

public class Utilisateur {
    protected String userMdp;
    protected String userMail;

    public Utilisateur(String userMdp, String userMail) {
        this.userMdp = userMdp;
        this.userMail = userMail;
    }

    public String getUserMdp() {
        return userMdp;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMdp(String userMdp) {
        this.userMdp = userMdp;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}