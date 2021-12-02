package projet;

public class Participant {
    String nom;
    String prenom;
    String telephone;
    String mail;
    Reservation reservation;

    public Participant() {
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
