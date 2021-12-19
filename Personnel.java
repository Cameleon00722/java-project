package projet;

import java.io.Serializable;
import java.util.Scanner;

public class Personnel extends Participant implements Serializable, Comparable {

    private int numero;
    //int max_table = 10;   1 table = 8 places
    //int max_place = 80;
    //String est_accompagné;
    //private boolean validation = false;

    public Personnel(String nom, String prenom, String telephone, String mail, int numero) {
        super(nom, prenom, telephone, mail);
        this.numero = numero;
    }
    //getters and setters
    public int getNumero() {
        return numero;
    }

    /*public void valide(String[] args){}{
        while(!validation){
            Scanner accompagné = new Scanner(System.in);
            est_accompagné = accompagné.next();
            if (est_accompagné.equals("oui") || est_accompagné.equals("OUI") || est_accompagné.equals("Oui")) {
                est_accompagné = "oui";
                validation = true;
            } else if(est_accompagné.equals("non") || est_accompagné.equals("NON") || est_accompagné.equals("Non")) {
                est_accompagné = "non";
                validation = true;
            }
            System.out.println(super.nom + super.prenom + "+" + est_accompagné);
        }
    }*/

    @Override
    public int compareTo(Object o) {
        Personnel p = (Personnel) o;
        return this.numero-p.numero;
    }
}
