package Vue;

import Modele.Client;

import java.util.ArrayList;
import Modele.Client;

public class VueClient {
    public void afficherClient(Client client) {
        // Afficher un client
        System.out.println("Id client : " + client.getClientId() + " Nom : " + client.getclientNom()
                + " Mail : " + client.getclientMail());
    }

    /**
     * Méthode qui affiche la liste des clients
     * @param clients = liste des clients
     */
    public void afficherListeClients(ArrayList<Client> clients) {
        // Afficher la liste des produits récupérés de l'objet de ProduitDAO
        for (Client client : clients) {
            afficherClient(client);
        }
    }
}
