package projet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Reservation implements Serializable,Comparable {

    private LocalDate date;
    private int numero_de_table;
    private int nombre_de_place;
    private double montant;
    private int nombre_accompagnateur;

    //Constructeurs
    public Reservation(LocalDate date, int num_table, int nbr_place, double montant) {
        this.date = date;
        this.numero_de_table = num_table;
        this.nombre_de_place = nbr_place;
        this.montant = montant;
        this.nombre_accompagnateur=determiner_nb_accompagnateur(nbr_place);
    }

    //getters et setters
    public int getNombre_accompagnateur(){
        return nombre_accompagnateur;
    }
    public int getNumero_de_table(){
        return numero_de_table;
    }

    int determiner_nb_accompagnateur(int nb_place){
        int nb_accompagnateur=0;
        if(nb_place==1){
            return nb_accompagnateur;
        }else{
            return nb_place-1;
        }
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


