/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import bean.Pompier;
import bean.Ventil;
import util.TrmtDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*import util.TrmtDate;*/

/**
 *
 * @author sio
 */
public class VentilMySQL {

    private final Connection theConnection = Connexion.getConnect("localhost", "sdis29", "adminBDsdis", "mdpBDsdis");

    public ArrayList<Ventil> getLesVentil(Calendar[] lesDates, String[] lesPeriodes, int caserne, int statut, int idPompier) {
        ArrayList<Ventil> lesVentil = new ArrayList<>();
        Ventil uneVentil;

        /* a. Initialisation de la collection lesVentil pour la période, 
            création d'une ventil par salarié, par date et période 
         */
        int indiceDateFin = lesDates.length - 1;
        Pompier lePompier;
        PompierMysql sm = new PompierMysql();
        System.out.println("Ceci est le :" + statut);
        ArrayList<Pompier> lesPompiers = sm.readAll(caserne);
        if (statut == 2) {
            for (Pompier unPompier : lesPompiers) {
                for (Calendar uneDate : lesDates) {
                    for (String unePeriode : lesPeriodes) {
                        uneVentil = new Ventil(uneDate, unePeriode, unPompier);
                        lesVentil.add(uneVentil);
                    }
                }
            }
        } else {
            System.out.println("Bonjour");
            System.out.println();

            for (int i = 0; i < lesPompiers.size(); i++) {
                Pompier leTest = lesPompiers.get(i);
                if (leTest.getId() == idPompier) {
                    Pompier pompierSolo = leTest;
                    for (Calendar uneDate : lesDates) {
                        for (String unePeriode : lesPeriodes) {
                            uneVentil = new Ventil(uneDate, unePeriode, pompierSolo);
                            lesVentil.add(uneVentil);
                        }
                    }
                }
            }

        }

        /* b) Maj de la collection lesVentil        
         */
        System.out.println(TrmtDate.getSQLDate(lesDates[0]));
        System.out.println(caserne);
        readAll(lesVentil, lesDates[0], lesDates[indiceDateFin], caserne);

        //System.out.println("lesVentil : " + lesVentil);
        return lesVentil;
    }

    public void readAll(ArrayList<Ventil> lesVentil, Calendar d1, Calendar d2, int caserne) {
        Pompier lePompier;
        Ventil uneVentil;
        Ventil laVentilTrouvee;
        String sql = "SELECT * FROM ventilation "
                + "INNER JOIN pompier on idPompier = id "
                + "WHERE jourVentil BETWEEN ? and ?;";
        try {
            PreparedStatement prepStmt = theConnection.prepareStatement(sql);
            prepStmt.setDate(1, TrmtDate.getSQLDate(d1));
            prepStmt.setDate(2, TrmtDate.getSQLDate(d2));
            ResultSet resultat = prepStmt.executeQuery();
            while (resultat.next()) {
                lePompier = new Pompier(resultat.getInt("id"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"));
                uneVentil = new Ventil(TrmtDate.getCalDate(resultat.getDate("jourVentil")),
                        resultat.getString("periode"),
                        lePompier);
                // Recherche si uneVentil existe dans les Ventil
                int indice = lesVentil.indexOf(uneVentil);
                if (indice > -1) {
                    laVentilTrouvee = lesVentil.get(indice);
                    laVentilTrouvee.setActivite(resultat.getInt("ventil"));
                    laVentilTrouvee.setGarde(resultat.getInt("garde"));
                    laVentilTrouvee.setIsInBD(true);

                }
            }
            prepStmt.close();
            resultat.close();
        } catch (SQLException ex) {
            System.out.println("SQLExeption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("Code erreur : " + ex.getErrorCode());
        }
    }

    /**
     * Suppression de la ventilation passée en paramètre
     *
     * @param v : ventilation à supprimer
     * @return : nb lignes supprimées ou -1 si erreur
     */
    public int delete(Ventil v) {
        int nbMAJ = -1;
        String sql = "DELETE FROM ventilation "
                + "WHERE idPompier = ? "
                + "AND periode = ? "
                + "AND jourVentil = ?;";
        try {
            PreparedStatement prepStmt = theConnection.prepareStatement(sql);
            prepStmt.setInt(1, v.getPompier().getId());
            prepStmt.setString(2, v.getPeriod());
            prepStmt.setDate(3, TrmtDate.getSQLDate(v.getJourVentil()));
            nbMAJ = prepStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLExeption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("Code erreur : " + ex.getErrorCode());
        }
        return nbMAJ;
    }

    /**
     * Création de la ventilation passée en paramètre
     *
     * @param v : ventilation à créer
     * @return : identifiant de la ventilation créé, ou -1 si erreur
     */
    public int create(Ventil v) {
        int idCree = -1;
        String sql = "INSERT into ventilation "
                + "(jourVentil, periode, idPompier, ventil, garde) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement prepStmt = null;
            prepStmt = theConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setDate(1, TrmtDate.getSQLDate(v.getJourVentil()));
            prepStmt.setString(2, v.getPeriod());
            prepStmt.setInt(3, v.getPompier().getId());
            prepStmt.setInt(4, v.getActivite());
            prepStmt.setInt(5, v.getGarde());

            System.out.println("create : " + prepStmt);
            int nbLigne = prepStmt.executeUpdate();

            // Recherche du no de la ventilation créée
            if (nbLigne > 0) {
                ResultSet result = prepStmt.getGeneratedKeys();
                if (result.next()) {
                    idCree = result.getInt(1);
                }
            }
            prepStmt.close();
        } catch (SQLException ex) {
            System.out.println("SQLExeption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("Code erreur : " + ex.getErrorCode());
        }
        return idCree;
    }

    /**
     * Mise à jour de la ventilation passée en paramètre
     *
     * @param v : ventilation à mettre à jour
     * @return : nb lignes mises à jour, -1 si erreur
     */
    public int update(Ventil v) {

        int nbMAJ = -1;
        String sql = "UPDATE ventilation "
                + "SET ventil = ?, garde=? "
                + "WHERE idPompier = ? "
                + "AND jourVentil = ? "
                + "AND periode = ?";
        try {
            PreparedStatement prepStmt = theConnection.prepareStatement(sql);
            prepStmt.setInt(1, v.getActivite());
            prepStmt.setInt(2, v.getGarde());
            prepStmt.setInt(3, v.getPompier().getId());
            prepStmt.setDate(4, TrmtDate.getSQLDate(v.getJourVentil()));
            prepStmt.setString(5, v.getPeriod());
            System.out.println("update : " + prepStmt);
            nbMAJ = prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentilMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbMAJ;
    }

    public ArrayList<Integer> getLesChecks() {
        ArrayList<Integer> lesChecks = null;
        return lesChecks;
    }

}
