package Projetpoo;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private class Etudiant {
        int numero_etu;
        String nom;
        String prenom;
        String telephone;
        String mail;
        byte annee_formation; //étant compris entre 1 et 5 pour limiter la ram usage



        public void reader(String args[])
        {
            String type = "student";
            try
            {
                // Le fichier d'entrée
                FileInputStream file = new FileInputStream("etudiant.txt");
                Scanner scanner = new Scanner(file);

                //renvoie true s'il y a une autre ligne à lire
                while(scanner.hasNextLine() && scanner != type)
                {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    private class Table {
        int numero_table;
        int place_libre; //8 places libres

        public void calcul_place() {
            if (place_libre == 0) {
                numero_table += 1;
                place_libre = 8;
            } else {
                place_libre -= 1;
            }

        }



        private class Reservation {
            LocalDate date;
            int num_table;
            int nbr_place;
            double montant;

            public boolean reserver_une_table(String nom_client){
                //ci-dessous une fonction pour déterminer le tarif
                String categorie_du_client="";
                Scanner choix_tarif_selon_categorie=new Scanner(System.in);
                boolean fin_choix=false;
                System.out.println("Veuillez indiqué votre catégorie : ");
                System.out.println("étudiant dernière année, étudiant ou personnel");
                System.out.println("Tapez respectivement EDA,E ou P");
                while(!fin_choix){
                    if(choix_tarif_selon_categorie.next().equals("EDA") || choix_tarif_selon_categorie.next().equals("E") || choix_tarif_selon_categorie.next().equals("P")){
                        categorie_du_client=choix_tarif_selon_categorie.next();
                        fin_choix=true;
                    }
                }


                return false;
            }
        }

    }
    private class Personnel {
        int numero;
        String nom;
        String prenom;
        String telephone;
        String mail;

        int max_table = 10;  // 1 table = 8 places
        int max_place = 80;

        private boolean validation = false;
        String est_accompagné;

        public void valide(String[] args){}{
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
                System.out.println(nom + prenom + "+" + est_accompagné);
            }
        }
    }




}
