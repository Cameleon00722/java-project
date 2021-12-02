package projet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	    try{
            Controleur monControleur=new Controleur(LocalDate.now());
            Scanner sc=new Scanner(System.in);
            if(sc.next().equals("sortie")){
                monControleur.quitter();
            }

        }
        catch(IOException e){

        }
        catch(ClassNotFoundException e){

        }
    }
}
