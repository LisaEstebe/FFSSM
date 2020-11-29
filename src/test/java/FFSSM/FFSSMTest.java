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
import org.junit.jupiter.api.*;

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
        LocalDate date1 = LocalDate.of(2000,2,13);
        LocalDate date2 = LocalDate.of(2001,1,11);
        plongeur1 = new Plongeur ("001","Estebe","Lisa","Adresse","tel",date1,2);
        moniteur1 = new Moniteur ("002","Chevailler","Salome","Adresse","tel",date2,3,5);
        club = new Club (moniteur1,"Les flots bleus","tel");
        site1= new Site ("Calanques","Details");
        plongee1= new Plongee (site1, moniteur1, LocalDate.now(), 13, 2);
    }
    
   /* @Test
    public void testNouvelleEmbauche(){
        LocalDate debut = LocalDate.of(2020,11,25);
        moniteur1.nouvelleEmbauche(club, debut);
        assertTrue(moniteur1.emplois().contains(this));
    }*/
    
    
   /*@Test
   public void employeurActuel() throws Exception{
       LocalDate debut = LocalDate.of(2020,11,25);
       moniteur1.nouvelleEmbauche(club, debut);
       assertEquals(club, moniteur1.employeurActuel(),
               "L'employeur actuel doit être club");
   }*/
    
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
    public void testLicenceValide(){
        //création d'une licence non conforme
        Licence licenceNonConforme = new Licence (plongeur1, "numero", LocalDate.of(2010, 11, 20), 1, club);
        
        assertFalse(licenceNonConforme.estValide(LocalDate.now()),
                "La licence n'est pas conforme");
        
    }
    
   /* @Test
    public void testPlongeesNonConformes(){
        //ajout d'une plongee conforme
        club.organisePlongee(plongee1);
        
        //création d'une plongée non conforme
        Plongeur plongeurNonConforme = new Plongeur ("numINSE", "Non-Conforme","Jean-Michel", "adresse", "tel", LocalDate.of(1990, 2, 10), 1);
        Licence licenceNonConforme = new Licence (plongeurNonConforme, "numero", LocalDate.of(2010, 11, 20), 1, club);
        Plongee plongeeNonConforme = new Plongee (site1, moniteur1, LocalDate.now(), 10, 2);
        plongeeNonConforme.ajouteParticipant(plongeurNonConforme);
        
        //ajout d'un plongee non conforme
        club.organisePlongee(plongeeNonConforme);
        
        assertEquals("plongeeNonConforme", club.plongeesNonConformes(),
                "Le club a organisé une plongée non conforme"); 
    }*/
   
}
