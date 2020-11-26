/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public HashSet<Plongee> myPlongees = new HashSet<>();

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club. Une
     * plongée est conforme si tous les plongeurs de la palanquée ont une
     * licence valide à la date de la plongée
     *
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        // TODO: Implémenter cette méthode
        HashSet<Plongee> pNonConf = new HashSet<>();
        for (Plongee plongee : myPlongees) {
            int nbPlongees = this.myPlongees.size();
            for (int i = nbPlongees - 1; i < 0; i--) {
                if (plongee.estConforme() == false) {
                    pNonConf.add(plongee);
                }
            }
        }
        return pNonConf;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     *
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        // TODO: Implémenter cette méthode
        myPlongees.add(p);
    }

    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
