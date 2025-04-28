package Modele;

import java.time.LocalDateTime;

public class Reservation {
    package Modele;

import java.time.LocalDateTime;

    public class Reservation {
        private int attractionId;
        private int clientId;
        private LocalDateTime dateReservation;
        private double prix;
        private int nbClient;

        public Reservation(int attractionId, int clientId, LocalDateTime dateReservation, double prix, int nbClient) {
            this.attractionId = attractionId;
            this.clientId = clientId;
            this.dateReservation = dateReservation;
            this.prix = prix;
            this.nbClient = nbClient;
        }

        public int getAttractionId() {return attractionId;}
        public int getClientId() {return clientId;}
        public LocalDateTime getDateReservation() {return dateReservation;}
        public double getPrix() {return prix;}
        public int getNbClient() {return nbClient;}

        public void setAttraction(int attractionId) {this.attractionId = attractionId;}
        public void setClient(int clientId) {this.clientId = clientId;}
        public void setDateReservation(LocalDateTime dateReservation) {this.dateReservation = dateReservation;}
        public void setPrix(double prix) {this.prix = prix;}
        public void setNbClient(int nbClient) {this.nbClient = nbClient;}
    }

}
