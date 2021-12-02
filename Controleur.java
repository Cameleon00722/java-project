package projet;


import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;


public class Controleur {
    Gala monGala;

    public Controleur(LocalDate date) throws IOException, ClassNotFoundException {
        ServiceStockage entrepot= new ServiceStockage();
        if(entrepot.charger()==null){
            monGala=new Gala(date);
        }else{
            monGala=(Gala) entrepot.charger();
        }


    }
    public void ctlAjouterTable(Object table){


    }
    public void quitter() throws IOException {
        ServiceStockage entrepot= new ServiceStockage();
        entrepot.enregistrer(monGala);
    }
}
