/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lisa
 */
public class FFSSMTest {
    private Plongeur plongeur1;
    private Moniteur moniteur1;
    private Club club;
    private Site site1;
    private Plongee plongee1;
    
    @BeforeEach
    public void setUp(){
        plongeur1 = new Plongeur ("001","Estebe","Lisa","Adresse","tel",LocalDate.of(2000,2,13),2);
        moniteur1 = new Moniteur ("002","Chevailler","Salome","Adresse","tel",LocalDate.of(2001,1,11),3,5);
        club = new Club (moniteur1,"Les flots bleus","tel");
        site1= new Site ("Calanques","Details");
        plongee1= new Plongee (site1, moniteur1, LocalDate.now(), 13, 2);
    }
    
 @Test
    public void testNouvelleEmbauche(){
     //On crée un nouveau moniteur qui n'a pas d'embauche
        Moniteur moniteur2 = new Moniteur ("INSEE","Nom","Prenom","adresse","tel",LocalDate.of(1990, 9, 12),3,123);
        
       //On s'assure que ce moniteur n'a aucune embauche
       assertTrue(moniteur2.emplois().isEmpty(),
               "Le moniteur ne doit pas encore avoir d'emploi");
       
        //On attribu une nouvelle embauche à ce moniteur
        moniteur2.nouvelleEmbauche(club, LocalDate.of(2020,11,25));
        
        assertFalse(moniteur2.emplois().isEmpty(), 
                "La liste des emplois du moniteur ne doit pas être vide");
    }
    
    
  @Test
   public void testEmployeurActuel(){
       Moniteur moniteur3 = new Moniteur ("INSEE","Nom","Prenom","adresse","tel",LocalDate.of(1990, 9, 12),3,123);
       
        //On s'assure que ce moniteur n'a aucune embauche
       assertTrue(moniteur3.emplois().isEmpty(),
               "Le moniteur ne doit pas encore avoir d'emploi");
       
       moniteur3.nouvelleEmbauche(club, LocalDate.now());
       
       assertEquals(club,moniteur3.employeurActuel(),
               "L'employeur actuel doit être club");
   }
    
    @Test
    public void testAjouteParticipant(){
        //ajout d'un participant à la plongee
        plongee1.ajouteParticipant(plongeur1);
        
        assertTrue( plongee1.myPlongeurs.contains(plongeur1),
                "Le plongeur1 participe à la plongee1");
    }
    
    
    @Test
    public void testOganisePlongee(){
        //ajout d'une plongee
        club.organisePlongee(plongee1);
        
        assertTrue(club.myPlongees.contains(plongee1),
                "plongee1 doit apparaître");
    }
    
    
    @Test
    public void testAjouteLicence(){
        //On s'assure que le plongeur1 n'a pas encore de licence 
        assertTrue(plongeur1.getLicence().isEmpty(),
                "Le plongeur ne doit pas encore avoir de licence");
        
        //On ajoute une licence au plongeur1
        plongeur1.ajouteLicence("numéro", LocalDate.now(), club);
        
 
        assertFalse(plongeur1.getLicence().isEmpty(),
                "Le plongeur doit avoir une licence");
    }
    
    
    @Test
    public void testLicenceValide(){
        //création d'une licence non conforme
        Licence licenceNonConforme = new Licence (plongeur1, "numero", LocalDate.of(2010, 11, 20), 1, club);
        
        assertFalse(licenceNonConforme.estValide(LocalDate.now()),
                "La licence n'est pas conforme");
        
    }
    
  @Test
    public void testPlongeesNonConformes(){
        //ajout d'une plongee conforme
        club.organisePlongee(plongee1);
        
        //création d'une plongée non conforme
        Plongeur plongeurNonConforme = new Plongeur ("numINSE", "Non-Conforme","Jean-Michel", "adresse", "tel", LocalDate.of(1990, 2, 10), 1);
        Plongee plongeeNonConforme = new Plongee (site1, moniteur1, LocalDate.now(), 10, 2);
        plongeeNonConforme.ajouteParticipant(plongeurNonConforme);
        
        //ajouter la licence au plongeur
        plongeurNonConforme.ajouteLicence("numero", LocalDate.of(2010, 11, 20), club);
        
        //ajout d'un plongee non conforme
        club.organisePlongee(plongeeNonConforme);
        
        assertTrue(club.plongeesNonConformes().contains(plongeeNonConforme),
                "Le club a organisé une plongée non conforme"); 
    }
    
    @Test
        public void testTerminer(){
            
            Embauche e = new Embauche (LocalDate.of(2019, 12, 11), moniteur1, club);
            
            assertEquals(moniteur1, e.getEmploye(),
                    "L'Embauche e emploi moniteur1");
           
            e.terminer(LocalDate.of(2020, 12, 11));
            
            assertFalse(moniteur1.emplois().contains(e),
                    "L'emploi e s'est terminé le 11/12/2020");
            
            assertTrue(e.estTerminee(),
                    "L'emploi e doit être terminé");
            
        }
        
        
   @Test
   public void testEstConforme(){
       Licence lOk = new Licence (plongeur1, "numero", LocalDate.of(2020, 11, 20), 1, club);
       Licence lNonConf = new Licence (plongeur1, "numero", LocalDate.of(2010, 11, 20), 1, club);
       
       assertTrue(lOk.estValide(LocalDate.now()),
               "La licence doit être conforme");
       
       assertFalse(lNonConf.estValide(LocalDate.now()),
               "La licence ne doit pas être conforme");
   }
   
}
