package projet;


import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;


public class Controleur {
    Gala monGala;

    public Controleur(LocalDate date) throws IOException, ClassNotFoundException {
        ServiceStockage entrepot1= new ServiceStockage();
        monGala=(Gala) entrepot1.charger();
        if(monGala==null){
            System.out.println("nouveau gala");
            monGala=new Gala(date);

        }else{
            System.out.println("chargement d'un ancien gala");
        }
    }
    public void ctlReservation(){

        monGala.effectuer_une_reservation(LocalDate.now(),2, 2,new Participant());
    }
    public void quitter() throws IOException {
        ServiceStockage entrepot2= new ServiceStockage();
        entrepot2.enregistrer(monGala);
    }
}
