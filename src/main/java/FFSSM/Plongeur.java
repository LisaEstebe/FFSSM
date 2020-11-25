package FFSSM;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {

    public int niveau;
    List<Licence> myLicences = new LinkedList<>();
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau){
    super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
    this.niveau=niveau;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club club){
        Licence licence = new Licence(this, numero, delivrance, niveau, club);
        myLicences.add(licence);
    } 
    
    public List<Licence> getLicence(){
        return myLicences;
    }
    
    
}
