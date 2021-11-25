package Projetpoo;

import java.time.LocalDate;

public class Main {

    private class etudiant {
        int numero_etu;
        String nom;
        String prenom;
        String telephone;
        String mail;
        byte annee_formation; //étant compris entre 1 et 5 pour limiter la ram usage
    }

    private class personel {
        int numero;
        String nom;
        String prenom;
        String telephone;
        String mail;
    }

    private class table {
        int num_table;
        int place_libre; //8 place libre

        public void clc_place() {
            if (place_libre == 0) {
                num_table += 1;
                place_libre = 8;
            } else {
                place_libre -= 1;
            }

        }

        private class reservation {
            LocalDate date;
            int num_table;
            int nbr_place;
            double montant;
        }

    }
}    
