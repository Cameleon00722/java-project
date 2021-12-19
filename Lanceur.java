package Projetpoo;
import java.util.Scanner;

public class Lanceur {

    public Lanceur() {
        boolean valide = false;
        while (valide != true) {

            System.out.print("entrer jour : ");
            Scanner jours = new Scanner(System.in);
            int day = jours.nextInt();

            if (day > 0 && day < 32) {
                System.out.print("entrer mois: ");
                Scanner mois = new Scanner(System.in);
                int mounth = mois.nextInt();

                if (mounth > 0 && mounth < 12) {
                    valide = true;
                    System.out.println("jour = " + day + " mois = " + mounth);
                    Ihm fen1 = new Ihm();
                } else {
                    System.out.println("mois invalide ");
                }
            } else {
                System.out.println("jour invalide ");
            }
        }
    }

    public static void main(String[] args){

        try {
            Lanceur try1 = new Lanceur();
        }
        catch(Exception e){
            System.out.println("La valeur rentrée n'était pas un chiffre");
        }

        }

    }

