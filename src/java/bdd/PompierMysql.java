/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;


import bean.Pompier;
import bean.User;
import util.MD5;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author frederic.duhin
 */
public class PompierMysql {
    Connection theConnection;
    private Pompier unPompier;
    private String resultat;
    private Pompier leConnecter;
    private Pompier vuePompier;

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    

    public PompierMysql() {
          theConnection = Connexion.getConnect( "localhost", "sdis29", "admin", "minda");
    }

public ArrayList<Pompier> readAll(int caserne){
         ArrayList<Pompier> lesPompiers = new ArrayList<>();
         try {
             PreparedStatement prepStmt;
             ResultSet resultQ = null;
             String sql = "SELECT * FROM pompier WHERE idCaserne= ? ORDER BY nom, prenom ";
             prepStmt = theConnection.prepareStatement(sql);
             prepStmt.setInt(1, caserne);
             resultQ = prepStmt.executeQuery();
             while (resultQ.next()) {
                unPompier = new Pompier(resultQ.getInt("id"),
                                        resultQ.getInt("idCaserne"),
                                        resultQ.getString("nom"),
                                        resultQ.getString("prenom"),
                                        resultQ.getInt("statut"),
                                        resultQ.getInt("typePers"),
                                        resultQ.getString("login"),
                                        resultQ.getString("mdp"),
                                        resultQ.getString("mail"),
                                        resultQ.getString("adresse"),
                                        resultQ.getString("cp"),
                                        resultQ.getString("ville"),
                                        resultQ.getString("bip"),
                                        resultQ.getInt("grade"));
              if(unPompier.getStatut() < 2) {                             
              lesPompiers.add(unPompier);
                 System.out.println("unPompier :" + unPompier);
              }
             }
             resultQ.close();
             prepStmt.close();
         } catch (SQLException ex) {
             System.out.println("SQLException : " + ex.getMessage());
             System.out.println("SQLState : " + ex.getSQLState());
             System.out.println("Code erreur : " + ex.getErrorCode());
         }
         return lesPompiers;
    }

    
    public void create(){
       
       
    }
    public void read(){
        
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
    
    public int createRP(Pompier c) {
        int id = -1;
            System.out.println("APPEL FONCTION CREATE RP");
        try {           
            PreparedStatement stmt = null;
            String sql =  "INSERT INTO pompier (idCaserne, nom, prenom, statut, typePers, mail, login, mdp, adresse, cp, ville, bip, grade) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            stmt = theConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, c.getIdCaserne());
            stmt.setString(2, c.getNom());
            stmt.setString(3, c.getPrenom());
            stmt.setInt(4, c.getStatut());
            stmt.setInt(5, c.getTypePers());
            stmt.setString(6, c.getMail());
            stmt.setString(7, c.getLogin());
            stmt.setString(8, c.getMdp());
            stmt.setString(9, c.getAdresse());
            stmt.setString(10, c.getCp());
            stmt.setString(11, c.getVille());
            stmt.setString(12, c.getBip());
            stmt.setInt(13, c.getGrade());
            System.out.println("Requête : " + stmt.toString());
            int status = stmt.executeUpdate();
            System.out.println(c);
            
            // Recherche de l'identifiant du client créé            
            if (status > 0) {
                ResultSet result = stmt.getGeneratedKeys();
                if (result.first()) {
                    id = result.getInt(1);                    
                }
            }               
        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("Code erreur : " + ex.getErrorCode());
        }        
        return id;
    }
            
public Pompier controlerPompier(String login, String mdp) {
        try {
        PreparedStatement prepStmt = null;
        String sql = "SELECT * FROM pompier WHERE login = ? AND mdp= ?";
        prepStmt = theConnection.prepareStatement(sql);
            prepStmt.setString(1, login);
            String mdpCrypt = MD5.encode(mdp);
            prepStmt.setString(2, mdpCrypt);
            ResultSet resultQ = null;
            resultQ = prepStmt.executeQuery();
            System.out.println(prepStmt);
            
            if(resultQ.next()) {
                leConnecter = new Pompier(resultQ.getInt("id"),
                                        resultQ.getInt("idCaserne"),
                                        resultQ.getString("nom"),
                                        resultQ.getString("prenom"),
                                        resultQ.getInt("statut"),
                                        resultQ.getInt("typePers"),
                                        resultQ.getString("mail"),
                                        resultQ.getString("login"),
                                        resultQ.getString("mdp"),
                                        resultQ.getString("adresse"),
                                        resultQ.getString("cp"),
                                        resultQ.getString("ville"),
                                        resultQ.getString("bip"),
                                        resultQ.getInt("grade"));
                System.out.println(leConnecter); }
         } catch (SQLException ex) {
             System.out.println("SQLException : " + ex.getMessage());
             System.out.println("SQLState : " + ex.getSQLState());
             System.out.println("Code erreur : " + ex.getErrorCode());
        }
        return leConnecter;
    }

public Pompier viewProfil(int id){
         
         try {
             PreparedStatement prepStmt = null;
             String sql = "SELECT * FROM pompier WHERE id=? ";
             prepStmt = theConnection.prepareStatement(sql);
             prepStmt.setInt(1, id);
             System.out.println(sql);
             ResultSet resultQ = null;
             resultQ = prepStmt.executeQuery();
             if(resultQ.next()) {
             vuePompier = new Pompier(resultQ.getInt("id"),
                                        resultQ.getInt("idCaserne"),
                                        resultQ.getString("nom"),
                                        resultQ.getString("prenom"),
                                        resultQ.getInt("statut"),
                                        resultQ.getInt("typePers"),
                                        resultQ.getString("login"),
                                        resultQ.getString("mdp"),
                                        resultQ.getString("mail"),
                                        resultQ.getString("adresse"),
                                        resultQ.getString("cp"),
                                        resultQ.getString("ville"),
                                        resultQ.getString("bip"),
                                        resultQ.getInt("grade"));
             }
                 System.out.println("unPompier :" + vuePompier);
         } catch (SQLException ex) {
             System.out.println("SQLException : " + ex.getMessage());
             System.out.println("SQLState : " + ex.getSQLState());
             System.out.println("Code erreur : " + ex.getErrorCode());
         }
         return vuePompier;
    }
}

