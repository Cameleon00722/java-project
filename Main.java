package projet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try{
            Controleur monControleur=new Controleur(LocalDate.now());
            monControleur.quitter();
        }
        catch(IOException e){
            System.out.println("erreur1"+e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("erreur2"+e.getMessage());
        }
    }
}
