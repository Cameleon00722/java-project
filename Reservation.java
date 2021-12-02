package projet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Reservation implements Serializable,Comparable {

    LocalDate date;
    int num_table;
    int nbr_place;
    double montant;

    //Constructeurs
    public Reservation(LocalDate date, int num_table, int nbr_place, double montant) {
        this.date = date;
        this.num_table = num_table;
        this.nbr_place = nbr_place;
        this.montant = montant;
    }




    public boolean reserver_une_table(String nom_client){
        //ci-dessous une fonction pour déterminer le tarif
        String categorie_du_client="";
        Scanner choix_tarif_selon_categorie=new Scanner(System.in);
        boolean fin_choix=false;
        System.out.println("Veuillez indiqué votre catégorie : ");
        System.out.println("étudiant dernière année, étudiant ou personnel");
        System.out.println("Tapez respectivement EDA,E ou P");
        while(!fin_choix){
            if(choix_tarif_selon_categorie.next().equals("EDA") || choix_tarif_selon_categorie.next().equals("E") || choix_tarif_selon_categorie.next().equals("P")){
                categorie_du_client=choix_tarif_selon_categorie.next();
                fin_choix=true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


