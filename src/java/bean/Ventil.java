/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author frederic.duhin
 */
public class Ventil {
    Calendar jourVentil ;
    String period ; 
    Pompier pompier;
    int activite; 
    int garde;
    boolean isInBD;

    public Ventil(Calendar jourVentil, String period, Pompier pompier, int activite, boolean isInBD, int garde) {
        this.jourVentil = jourVentil;
        this.period = period;
        this.pompier = pompier;
        this.activite = activite;
        this.garde = garde;
        this.isInBD = isInBD;
    }

    public Ventil(Calendar jourVentil, String period, Pompier pompier) {
        this.jourVentil = jourVentil;
        this.period = period;
        this.pompier = pompier;
    }

    public int getGarde() {
        return garde;
    }

    public void setGarde(int garde) {
        this.garde = garde;
    }

    
    public Calendar getJourVentil() {
        return jourVentil;
    }

    public void setJourVentil(Calendar jourVentil) {
        this.jourVentil = jourVentil;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Pompier getPompier() {
        return pompier;
    }

    public void setPompier(Pompier pompier) {
        this.pompier = pompier;
    }

    public int getActivite() {
        return activite;
    }

    public void setActivite(int activite) {
        this.activite = activite;
    }

    public boolean isInBD() {
        return isInBD;
    }

    public void setIsInBD(boolean isInBD) {
        this.isInBD = isInBD;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.jourVentil);
        hash = 23 * hash + Objects.hashCode(this.period);
        hash = 23 * hash + Objects.hashCode(this.pompier);
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
        final Ventil other = (Ventil) obj;
        if (!Objects.equals(this.period, other.period)) {
            return false;
        }
        if (!Objects.equals(this.jourVentil, other.jourVentil)) {
            return false;
        }
        if (!Objects.equals(this.pompier, other.pompier)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ventil{" + "jourVentil=" + jourVentil + ", period=" + period + ", pompier=" + pompier + ", activite=" + activite + ", garde=" + garde + ", isInBD=" + isInBD + '}';
    }


    
    
    
}
