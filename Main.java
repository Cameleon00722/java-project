package Projetpoo;

import java.time.LocalDate;

public class Main { 

    private class Etudiant {
        int numero_etu;
        String nom;
        String prenom;
        String telephone;
        String mail;
        byte annee_formation; //étant compris entre 1 et 5 pour limiter la ram usage
    }

    private class Personnel {
        int numero;
        String nom;
        String prenom;
        String telephone;
        String mail;
        
        int max-table = 10;  // 1 table = 8 places
        int max-place = 80;
        
        Boolean validé = False;
        string est-accompagné;
        
        while (validé == False){
        Scanner accompagné = new Scanner(System.in);
        est-accompagné = accompagné.next();
        
          if (est-accompagné.equals("oui") || est-accompagné.equals("OUI") || est-accompagné.equals("Oui") ){
              est-accompagné = oui; 
              validé = True;
          }else if(est-accompagné.equals("non") || est-accompagné.equals("NON") || est-accompagné.equals("Non")){
              est-accompagné = non; 
              validé = True;
          }
        Systemout.println(nom + prenom + "+" + est-accompagné)
        
        
    }

    private class Table {
        int numero_table;
        int place_libre; //8 places libres

        public void calcul_place() {
            if (place_libre == 0) {
                numumero_table += 1;
                place_libre = 8;
            } else {
                place_libre -= 1;
            }

        }

        private class Reservation {
            LocalDate date;
            int num_table;
            int nbr_place;
            double montant;
        }

    }
}    
