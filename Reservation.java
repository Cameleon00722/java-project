package projet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Reservation implements Serializable,Comparable {

    LocalDate date;
    int numero_de_table;
    int nombre_de_place;
    double montant;

    //Constructeurs
    public Reservation(LocalDate date, int num_table, int nbr_place, double montant) {
        this.date = date;
        this.numero_de_table = num_table;
        this.nombre_de_place = nbr_place;
        this.montant = montant;
    }


    @Override
    public String toString(){
        String leRetour="";
        leRetour+= ("date : "+date.toString()+"\n\r");
        leRetour+= ("numero de table : "+numero_de_table+"\n\r");
        leRetour+= ("nombre de place : "+nombre_de_place+"\n\r");
        leRetour+=("montant : "+montant+"\n\r");
        return leRetour;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


