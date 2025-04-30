package Modele;

public class Utilisateur {
    protected int id;
    protected String userMdp;
    protected String userMail;

    public Utilisateur(int id) {
        this.id = id;
    }

    public Utilisateur(int id, String userMdp, String userMail) {
        this.id = id;
        this.userMdp = userMdp;
        this.userMail = userMail;
    }

    public int getClientId() {
        return id;
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
