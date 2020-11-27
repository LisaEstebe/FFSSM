/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;
        
        public List<Plongeur> myPlongeurs = new LinkedList<>();

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}
        

	public void ajouteParticipant(Plongeur participant) {
		// TODO: Implémenter cette méthode
		myPlongeurs.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		// TODO: Implémenter cette méthode
                
		for (Plongeur participant : myPlongeurs){
                   int nbLicences=participant.myLicences.size();
                   for(int i = nbLicences-1;i<0;i--){
                       if(participant.myLicences.get(i).estValide(this.getDate())){
                           break;
                       }
                   }
                   return false;
                }
                return true;
        }

}
