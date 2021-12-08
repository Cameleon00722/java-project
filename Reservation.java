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
    public void supprimer_reservation(Participant participant){
        int table_reservee = participant.reservation.num_table;
        if (participant.est_accompagné()) {
            for (String s : PlanTable.plan(table_reservee)){ // parcourir plan de table
                for(String acc : participant.accompagnant){
                    if (s.equals(participant.prenom)){ // si on trouve le participant
                        PlanTable.supprimer(table_reservee, participant.prenom);
                    }
                    else if(s.equals(acc)){ // si on trouve un accompagnant du participant
                        PlanTable.supprimer(table_reservee, acc);
                    }
                }
            }
        }
        else {
            for (String s : PlanTable.plan(table_reservee)) {//parcourir les elements de la table
                if (s.equals(participant.prenom)) { //si elemnts = particpant ou accompagnateur du participant
                    PlanTable.supprimer(table_reservee, participant.prenom); //supprimer de la table
                }
            }
        }
        System.out.println("Réservation supprimée");
    }
}


