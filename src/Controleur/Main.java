package Controleur;

// import des packages
import java.sql.*;
import DAO.*;
import Modele.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Déclaration et instanciation des objets des classes DaoFactory, ProduitDAOImpl, VueProduit,
        // ClientDAOImpl, VueClient, CommanderDAOImpl et VueCommander
        DaoFactory dao = DaoFactory.getInstance("parcattraction", "root", "");
        ClientDAOImpl clidao = new ClientDAOImpl(dao);


        // Récupérer la liste des clients de la base de données avec l'objet clidao de la classe ClientDAOImpl
        ArrayList<Client> clients = clidao.getAll();


        Scanner scanner = new Scanner(System.in);

// CONSIGNES 2 A 9 POUR LES PRODUITS

     /*   System.out.print("Veuillez entrer le nom du nouveau produit : ");
        String nom = scanner.nextLine();
        System.out.print("Veuillez entrer le prix du nouveau produit : ");
        double prix = scanner.nextDouble();
        scanner.nextLine(); // Consommer la nouvelle ligne

        // Question 3 : on instancie un objet de Produit avec ce nom et ce prix
        Produit nouveauProduit = new Produit(0, nom, prix);
        // Question4 o, ajoute cet objet dans la table produits de la BDD
        prodao.ajouter(nouveauProduit);
        System.out.println("Le nouveau produit a été ajouté en légende!");

        // Question 5 : On saisit un identifiant (int) de produit
        System.out.print("Entrez l'ID du produit à modifier : ");
        int produitId = scanner.nextInt();
        scanner.nextLine();

        // Question 6 : On cherche un produit avec l'identifiant saisi
        Produit produitTrouve = prodao.chercher(produitId);
        if (produitTrouve == null) {
            System.out.println("L'identifiant de ce produit n'est pas dans la table produits.");
        } else {
            // Et on affiche le produit trouvé à partir de vuepro
            vuepro.afficherProduit(produitTrouve);
        }

        // Question 7 : On modifie le prix du produit ajouté
        System.out.print("Entrez le nouveau prix du produit : ");
        double nouveauPrix = scanner.nextDouble();
        scanner.nextLine();
        nouveauProduit.setProduitPrix(nouveauPrix);

        // Modifier le produit dans la BDD avec notre fonction modifier et prodao
        prodao.modifier(nouveauProduit);
        System.out.println("Produit modifié avec succès !");

        // On affiche le produit modifié toujours avec vuepro
        vuepro.afficherProduit(nouveauProduit);

        // On supprime le produit de la BDD
        // ET on demande à l'utilisateur de saisir l'ID du produit à supprimer
        System.out.print("Entrez l'ID du produit à supprimer : ");
        int produitIdToDelete = scanner.nextInt();
        scanner.nextLine();

        // On recupere le produit à supprimer
        Produit produitASupprimer = prodao.chercher(produitIdToDelete);
        if (produitASupprimer == null) {
            System.out.println("L'identifiant de ce produit n'est pas dans la table produits.");
        } else {
            // Et on supprime le produit de la BDD avec prodao
            prodao.supprimer(produitASupprimer);
            System.out.println("Produit supprimé avec succès !");} */


// CONSIGNES 2 A 9 POUR LES CLIENTS

        System.out.print("Veuillez entrer le nom du nouveau client : ");
        String nom = scanner.nextLine();
        System.out.print("Veuillez entrer prenom du nouveau client : ");
        String prenom = scanner.nextLine();
        System.out.print("Veuillez entrer le mail du nouveau client : ");
        String mail = scanner.nextLine();
        System.out.print("Veuillez entrer Mot de passe du nouveau client : ");
        String mdp = scanner.nextLine();
        System.out.print("Veuillez entrer la date de naissance du nouveau client (format AAAA-MM-JJ) : ");
        String dateNaissanceStr = scanner.nextLine();
        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr);


        // Q3 On instancie un objet de client avec ce com et ce mail
        Client nouveauClient = new Client(mdp,mail, nom, prenom,dateNaissance,0); // Ici l'ID est mis à 0 car il sera généré automatiquement

        // Q4 On ajoute cet objet dans la table clients de la BDD
        clidao.ajouter(nouveauClient);
        System.out.println("Nouveau client ajouté avec succès !");

      /*  // Q5 on saisi un identifiant (int) de client
        System.out.print("Veuillez entrer l'ID du client à chercher : ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        // Q6 On cherche un client avec l'identifiant saisi dans la BDD
        Client clientTrouve = clidao.chercher(clientId);
        if (clientTrouve == null) {
            System.out.println("L'identifiant de ce client n'est pas dans la table clients.");
        } else {
            // On affiche le client trouvé avec vuecli
            vuecli.afficherClient(clientTrouve);
        }

        // Q7 on modifie l'email qu'on a ajouté suite à la Q3
        System.out.print("Veuillez entrer le nouvel email du client : ");
        String nouvelEmail = scanner.nextLine();
        nouveauClient.setclientMail(nouvelEmail);

        // On modifie les clients dans la BDD
        clidao.modifier(nouveauClient);
        System.out.println("Client modifié avec succès !");

        // On affiche le client modifié encore une fois avec vuecli
        vuecli.afficherClient(nouveauClient);

        // On demande à l'utilisateur de saisir l'ID du client à supprimer
        System.out.print("Veuillez entrer l'ID du client à supprimer : ");
        int clientIdASupress = scanner.nextInt();
        scanner.nextLine();

        // On recupère le client à supprimer en se servant de notre fonction chercher
        Client clientASupprimer = clidao.chercher(clientIdASupress);
        if (clientASupprimer == null) {
            System.out.println("L'identifiant de ce client n'est pas dans la table clients.");
        } else {
            // Endin on supprime le client de la BDD avec clidao
            clidao.supprimer(clientASupprimer);
            System.out.println("Client supprimé avec succès !");
        }




// CONSIGNES 2 A 9 POUR COMMANDER

        /* COMMENTAIRE/EXPLICATIONS : Dans cette p*/
/*
        System.out.print("Veuillez entrer l'ID du client : ");
        int clientId = scanner.nextInt();
        System.out.print("Veuillez entrer l'ID du produit : ");
        int produitId = scanner.nextInt();
        System.out.print("Veuillez entrer la quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        //  Q3 on instencie un objet de Commander
        Commander nouvelleCommande = new Commander(clientId, produitId, quantite);

        // Q4 on ajoute cet objet dans la table commander de la BDD
        comdao.ajouter(nouvelleCommande);
        System.out.println("Nouvelle commande ajoutée avec succès !");

        // Q5 on saisit un identifiant (int) de commander ce qui revient à saisir un identifiant (int) de client et un identifiant (int) de produit
        System.out.print("Veuillez entrer l'ID du client pour chercher la commande : ");
        int clientIdChercher = scanner.nextInt();
        System.out.print("Veuillez entrer l'ID du produit pour chercher la commande : ");
        int produitIdChercher = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        //Q6 On recherche une commande avec les identifiants
        Commander commandeTrouvee = comdao.chercher(clientIdChercher, produitIdChercher);
        if (commandeTrouvee == null) {
            System.out.println("La commande n'existe pas dans la table.");
        } else {
            // On affiche la commande trouvée en appelant la méthode afficherProduit de l'objet vuecom,
            // avec l'objet de la commande récupérée en paramètre.
            vuecom.afficherCommande(commandeTrouvee, dao);
        }

        // Q7.1 On modifie la quantité de la commande ajoutée
        System.out.print("Veuillez entrer la nouvelle quantité pour la commande : ");
        int nouvelleQuantite = scanner.nextInt();
        scanner.nextLine();
        nouvelleCommande.setQuantite(nouvelleQuantite);

        // Q7.2 on modifie la commande dans la BDD en appelant la méthode comdao
        comdao.modifier(nouvelleCommande);
        System.out.println("Commande modifiée avec succès !");

        // Q7.3 On affiche la commande modifiée en appelant la méthode vuecom
        vuecom.afficherCommande(nouvelleCommande, dao);

        // Q8 Pour supprimer la commande : on demande à l'utilisateur de saisir l'ID du client et l'ID du produit
        System.out.print("Veuillez entrer l'ID du client pour supprimer la commande : ");
        int clientIdSupprimer = scanner.nextInt();
        System.out.print("Veuillez entrer l'ID du produit pour supprimer la commande : ");
        int produitIdSupprimer = scanner.nextInt();
        scanner.nextLine();

        // On récupère la commande recherchée à l'aide de la fonction chercher
        Commander commandeASupprimer = comdao.chercher(clientIdSupprimer, produitIdSupprimer);
        if (commandeASupprimer == null) {
            System.out.println("La commande avec les identifiants spécifiés n'existe pas dans la table commander.");
        } else {
            // On supprime la commande de la BDD avec comdao
            comdao.supprimer(commandeASupprimer);
            System.out.println("Commande supprimée avec succès !");
        }

 */
        // On ferme la connexion
        dao.disconnect();

        // Enfin on ferme le scanner
        scanner.close();
    }
}

