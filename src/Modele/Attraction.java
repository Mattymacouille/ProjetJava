package Modele;

public class Attraction {
    private int attractionId;
    private String attractionNom;
    private int nbAttraction;
    private double prix;

    // constructeur
    public Attraction (int attractionId, String attractionNom, int nbAttraction, double prix) {
        this.attractionId = attractionId;
        this.attractionNom = attractionNom;
        this.nbAttraction = nbAttraction;
        this.prix = prix;
    }

    public int getAttractionId() { return attractionId; }
    public String getAttractionNom() { return attractionNom; }
    public double getPrix() { return prix; }
    public int getNbAttraction() { return nbAttraction; }

    public void setPrix(double prix) { this.prix = prix; }
    public void setAttractionNom(String attractionNom) { this.attractionNom = attractionNom; }
    public void setNbAttraction(int nbAttraction) { this.nbAttraction = nbAttraction; }
}
