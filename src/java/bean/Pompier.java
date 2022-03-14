/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Objects;

/**
 *
 * @author frederic.duhin
 */
public class Pompier {
    private int id;
    private int idCaserne;
    private String nom;
    private String prenom;
    private int statut;
    private int typePers;
    private String mail;
    private String login;
    private String mdp;
    private String adresse;
    private String cp;
    private String ville;
    private String bip;
    private int grade;

    public Pompier() {
    }



    public Pompier(int id, int idCaserne, String nom, String prenom, int statut, int typePers, String mail, String login, String mdp, String adresse, String cp, String ville, String bip, int grade) {
        this.id = id;
        this.idCaserne = idCaserne;
        this.nom = nom;
        this.prenom = prenom;
        this.statut = statut;
        this.typePers = typePers;
        this.mail = mail;
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.bip = bip;
        this.grade = grade;
    }

    public Pompier(int idCaserne, String nom, String prenom, int statut, int typePers, String mail, String login, String mdp, String adresse, String cp, String ville, String bip, int grade) {
        this.idCaserne = idCaserne;
        this.nom = nom;
        this.prenom = prenom;
        this.statut = statut;
        this.typePers = typePers;
        this.mail = mail;
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.bip = bip;
        this.grade = grade;
    }

    public Pompier(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCaserne() {
        return idCaserne;
    }

    public void setIdCaserne(int idCaserne) {
        this.idCaserne = idCaserne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getTypePers() {
        return typePers;
    }

    public void setTypePers(int typePers) {
        this.typePers = typePers;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getBip() {
        return bip;
    }

    public void setBip(String bip) {
        this.bip = bip;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nom);
        hash = 37 * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pompier other = (Pompier) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Pompier{" + "id=" + id + ", idCaserne=" + idCaserne + ", nom=" + nom + ", prenom=" + prenom + ", statut=" + statut + ", typePers=" + typePers + ", mail=" + mail + ", login=" + login + ", mdp=" + mdp + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", bip=" + bip + ", grade=" + grade + '}';
    }


    
    
}
