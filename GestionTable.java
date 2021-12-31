package com.company;

import java.util.HashMap;
import java.util.Map;

public class GestionTable {

    public static void main(String[] args){
        boolean etudiant = true;
        int nbrP = 6;
        int Compteur = 0; // vérifie que la boucle est terminé

        // integer représente le nbr de place libre
        // 10 table personel

        Map<String, Integer> TableP = new HashMap<>();
        TableP.put("Table n°1", 8);
        TableP.put("Table n°2", 8);
        TableP.put("Table n°3", 8);
        TableP.put("Table n°4", 8);
        TableP.put("Table n°5", 8);
        TableP.put("Table n°7", 8);
        TableP.put("Table n°8", 8);
        TableP.put("Table n°9", 8);
        TableP.put("Table n°10", 8);


        // 15 table etu
        Map<String, Integer> TableEtu = new HashMap<>();
        TableEtu.put("Table n°1", 8);
        TableEtu.put("Table n°2", 8);
        TableEtu.put("Table n°3", 8);
        TableEtu.put("Table n°4", 8);
        TableEtu.put("Table n°5", 8);
        TableEtu.put("Table n°7", 8);
        TableEtu.put("Table n°8", 8);
        TableEtu.put("Table n°9", 8);
        TableEtu.put("Table n°10", 8);
        TableEtu.put("Table n°11", 8);
        TableEtu.put("Table n°12", 8);
        TableEtu.put("Table n°13", 8);
        TableEtu.put("Table n°14", 8);
        TableEtu.put("Table n°15", 8);


        if (!etudiant){
            System.out.println("Personel : ");

            for (Map.Entry<String, Integer> element : TableP.entrySet()){

                if (element.getValue() >= nbrP){
                    element.setValue(element.getValue() - nbrP);
                    System.out.println("emplacement : " + element.getKey() + " place libre  restant " + element.getValue());
                    break;
                }else if (Compteur == 10){
                    System.err.println("plus de place disponible merci de contacter l'organisation");
                }

                Compteur += 1;
            }

        }else{
            System.out.println("étudiant : ");


            for (Map.Entry<String, Integer> element : TableEtu.entrySet()){


                if (element.getValue() >= nbrP){
                    element.setValue(element.getValue() - nbrP);
                    System.out.println("emplacement : " + element.getKey() + " place libre restant " + element.getValue());
                    break;
                }else if (Compteur == 10){
                    System.err.println("plus de place disponible merci de contacter l'organisation");
                }

                Compteur += 1;
            }


        }

    }

}
