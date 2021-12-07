package projet;

import java.io.Serializable;

public class Participant implements Serializable {
    String nom;
    String prenom;
    String telephone;
    String mail;
    Reservation reservation;
    //ajouter un champ nombre accompagnant
    //qui se déduit du nombre de place dans la réservation

    public Participant() {
    }
    public String getNom(){
        return nom;
    }

    public Participant(String nom, String prenom, String telephone, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
    }

    public void associer_reservation(Reservation reservation){
        this.reservation=reservation;
    }
}
