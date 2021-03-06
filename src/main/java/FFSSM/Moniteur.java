/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> myEmbauches= new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() throws Exception{
         // TODO: Implémenter cette méthode
      if(emplois().isEmpty()) 
            throw new Exception("Aucun emploi");
    
      if (emplois().get((emplois().size())-1).estTerminee()) 
            throw new Exception("Dernier emploi terminé");
     
      return Optional.ofNullable(emplois().get((emplois().size())-1).getEmployeur());
      }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         // TODO: Implémenter cette méthode
        Embauche embauche = new Embauche (debutNouvelle, this , employeur);
        myEmbauches.add(embauche);	    
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
        return myEmbauches;
        }
}
