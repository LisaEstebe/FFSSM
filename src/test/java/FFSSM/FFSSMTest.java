/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
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
    
    @BeforeEach
    public void setUp() throws Exception {
        LocalDate date1 = LocalDate.of(2000,2,13);
        LocalDate date2 = LocalDate.of(2001,1,11);
        plongeur1 = new Plongeur ("001","Estebe","Lisa","Adresse","tel",date1,2);
        moniteur1 = new Moniteur ("002","Chevailler","Salome","Adresse","tel",date2,3,5);
        club = new Club (moniteur1,"Les flots bleus","tel");
    }
    
    @Test
    public void testNouvelleEmbauche() throws Exception{
        moniteur1.nouvelleEmbauche(club, LocalDate.EPOCH);
        assertEquals(club,moniteur1.employeurActuel(),
                "L'employeur actuel doit être club");
    }
    
    
    
    
   @Test
   public void testAjouteLicence(){
       plongeur1.ajouteLicence("001",LocalDate.of(2020, 11, 26),club);
       ;
       
   }

   
   
}
