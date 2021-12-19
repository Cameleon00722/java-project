package projet;

import java.io.Serializable;

public class Participant implements Serializable {
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private Reservation reservation;

    //getters and setters
    public String getNom(){
        return nom;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Participant() {
    }

    public Participant(String nom, String prenom, String telephone, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.reservation=null;
    }

    public void associer_reservation(Reservation reservation){
        this.reservation=reservation;
    }
    public void supprimer_reservation() { this.reservation=null;}
}
