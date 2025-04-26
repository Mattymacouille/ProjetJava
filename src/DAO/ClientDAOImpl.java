package DAO;

// import des packages
import Modele.Client;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * implémentation MySQL du stockage dans la base de données des méthodes définies dans l'interface
 * ClientDAO.
 */
public class ClientDAOImpl implements ClientDAO {
    private DaoFactory daoFactory;

    public ClientDAOImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Client> getAll() {
        ArrayList<Client> listeClients = new ArrayList<>();

        try {
            Connection connexion = daoFactory.getConnection();
            Statement statement = connexion.createStatement();
            ResultSet resultats = statement.executeQuery("SELECT * FROM client");

            while (resultats.next()) {
                int clientId = resultats.getInt("id_client");
                String userMail = resultats.getString("mail");
                String userMdp = resultats.getString("mdp");
                String nom = resultats.getString("nom");
                String prenom = resultats.getString("prenom");
                LocalDate dateNaissance = resultats.getDate("date_naissance").toLocalDate();

                Client client = new Client(userMdp, userMail, nom, prenom, dateNaissance, clientId);
                listeClients.add(client);
            }

            resultats.close();
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Création de la liste de clients impossible");
        }

        return listeClients;
    }

    public void ajouter(Client client) {
        try {
            Connection connexion = daoFactory.getConnection();
            String sqlUtilisateur = "INSERT INTO Utilisateur (mail, mdp) VALUES (?, ?)";
            PreparedStatement psUtilisateur = connexion.prepareStatement(sqlUtilisateur);
            psUtilisateur.setString(1, client.getUserMail());
            psUtilisateur.setString(2, client.getUserMdp());
            psUtilisateur.executeUpdate();

            String sqlClient = "INSERT INTO client (mail, mdp, nom, prenom, date_naissance) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psClient = connexion.prepareStatement(sqlClient);

            psClient.setString(1, client.getUserMail());
            psClient.setString(2, client.getUserMdp());
            psClient.setString(3, client.getNom());
            psClient.setString(4, client.getPrenom());
            psClient.setDate(5, Date.valueOf(client.getDateNaissance()));

            psClient.executeUpdate();

            psClient.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ajout du client impossible");
        }
    }

    public Client chercher(int id) {
        Client client = null;

        try {
            Connection connexion = daoFactory.getConnection();
            String sql = "SELECT * FROM clients WHERE clientID = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultats = statement.executeQuery();

            if (resultats.next()) {
                int clientId = resultats.getInt("clientID");
                String userMail = resultats.getString("userMail");
                String userMdp = resultats.getString("userMdp");
                String nom = resultats.getString("clientNom");
                String prenom = resultats.getString("clientPrenom");
                LocalDate dateNaissance = resultats.getDate("clientDateNaissance").toLocalDate();

                client = new Client(userMdp, userMail, nom, prenom, dateNaissance, clientId);
            }

            resultats.close();
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Client non trouvé dans la base de données");
        }

        return client;
    }

    public Client modifier(Client client) {
        try {
            Connection connexion = daoFactory.getConnection();

            String sql = "UPDATE clients SET userMail = ?, userMdp = ?, clientNom = ?, clientPrenom = ?, clientDateNaissance = ? WHERE clientID = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);

            statement.setString(1, client.getUserMail());
            statement.setString(2, client.getUserMdp());
            statement.setString(3, client.getNom());
            statement.setString(4, client.getPrenom());
            statement.setDate(5, Date.valueOf(client.getDateNaissance()));
            statement.setInt(6, client.getClientId());

            statement.executeUpdate();

            statement.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Modification du client impossible");
        }

        return client;
    }

    @Override
    public void supprimer(Client client) {
        try {
            Connection connexion = daoFactory.getConnection();
            connexion.setAutoCommit(false);

            String sqlCommandes = "DELETE FROM commander WHERE clientID = ?";
            PreparedStatement statementCommandes = connexion.prepareStatement(sqlCommandes);
            statementCommandes.setInt(1, client.getClientId());
            statementCommandes.executeUpdate();

            String sqlClient = "DELETE FROM clients WHERE clientID = ?";
            PreparedStatement statementClient = connexion.prepareStatement(sqlClient);
            statementClient.setInt(1, client.getClientId());
            statementClient.executeUpdate();

            connexion.commit();

            statementCommandes.close();
            statementClient.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Suppression du client impossible");
        }
    }
}
