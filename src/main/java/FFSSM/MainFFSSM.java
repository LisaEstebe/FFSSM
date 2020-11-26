package FFSSM;

import java.time.LocalDate;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lisa
 */
public class MainFFSSM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        LocalDate date1 = LocalDate.of(2000,2,13);
        LocalDate date2 = LocalDate.of(2001,1,11);
        LocalDate date3 = LocalDate.of(2020,9,26);
        LocalDate date4 = LocalDate.of(2020,11,26);
        
        Moniteur giselle = new Moniteur ("2 00 02 31 555 662 19", "Dupont", "Giselle","Adresse","tel", date1 ,3 ,12345);
        
        Plongeur gertrude = new Plongeur ("2 01 01 45 555 662 19","Bertrand","Gertrude","Adress","tel", date2, 2);
        
        Plongeur gertrudebis = new Plongeur ("2 01 01 45 555 662 19","Bertrand","Gertrude","Adress","tel", date2, 2);
        
        Club pandemonium = new Club (giselle,"Pandemonium","tel");
       
        Licence l = new Licence (gertrude, "019", date1, 2, pandemonium);
        
        l.estValide(date4);
        
        Site s = new Site ("Calanques","C'est joli");
        
        gertrude.ajouteLicence("021", date3, pandemonium);
       
        System.out.println(pandemonium.toString());
        
        giselle.nouvelleEmbauche(pandemonium, date3);
        
        System.out.println(giselle.employeurActuel());
        
        
    }
    
}
