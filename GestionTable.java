package projet;

import java.util.HashMap;
import java.util.Map;

public class GestionTable {

    static Map<Integer, Integer> TableP = new HashMap<>();
    static Map<Integer, Integer> TableEtu = new HashMap<>();

    boolean etudiant = true;
    int nbrP = 6;
    static int Compteur = 0; // vérifie que la boucle est terminé

    public GestionTable() {
        // integer représente le nbr de place libre
        // 10 table personel
        TableP.put(1, 8);
        TableP.put(2, 8);
        TableP.put(3, 8);
        TableP.put(4, 8);
        TableP.put(5, 8);
        TableP.put(6, 8);
        TableP.put(7, 8);
        TableP.put(8, 8);
        TableP.put(9, 8);
        TableP.put(10, 8);

        // 15 table etu
        TableEtu.put(11, 8);
        TableEtu.put(12, 8);
        TableEtu.put(13, 8);
        TableEtu.put(14, 8);
        TableEtu.put(15, 8);
        TableEtu.put(16, 8);
        TableEtu.put(17, 8);
        TableEtu.put(18, 8);
        TableEtu.put(19, 8);
        TableEtu.put(20, 8);
        TableEtu.put(21, 8);
        TableEtu.put(22, 8);
        TableEtu.put(23, 8);
        TableEtu.put(24, 8);
        TableEtu.put(25, 8);
    }

    public static boolean ChoixAuto(Participant participant, int nbplace) {
        boolean res = false;
        if (participant instanceof Etudiant) {
            for (Map.Entry<Integer, Integer> element : TableEtu.entrySet()) {
                if (element.getValue() >= nbplace) {
                    element.setValue(element.getValue() - nbplace);
                    res = true;
                    break;
                } else if (Compteur == 10) {
                    break;
                }
                Compteur += 1;
            }
            return res;

        } else {
            for (Map.Entry<Integer, Integer> element : TableP.entrySet()) {
                if (element.getValue() >= nbplace) {
                    element.setValue(element.getValue() - nbplace);
                    break;
                } else if (Compteur == 15) {
                    break;
                }
                Compteur += 1;
            }
            return res;

        }

    }

    public boolean Inserer(Participant participant, int numTable, int nbPlace) {
        if (participant instanceof Etudiant) {
            if (TableEtu.containsKey(numTable)) {
                int n = TableEtu.get(numTable);
                TableEtu.replace(numTable, n, n - nbPlace);
                return true;
            } else {
                return false;
            }
        } else {
            if (TableP.containsKey(numTable)) {
                int n = TableP.get(numTable);
                TableP.replace(numTable, n, n - nbPlace);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean supprimer(Participant participant) {
        if (participant.reservation != null) { // une reservation
            int numtable = participant.reservation.getNumero_de_table();
            int nbplace = participant.reservation.getNombre_accompagnateur() + 1;
            if (participant instanceof Etudiant) {
                int nbplacelibre = TableEtu.get(numtable);
                TableEtu.replace(numtable, nbplacelibre, nbplacelibre + nbplace);
                return true;
            }
            else {
                int nbplacelibre = TableP.get(numtable);
                TableP.replace(numtable, nbplacelibre, nbplacelibre + nbplace);
                return true;
            }
        }
        else {
            return false; // pas de reservation
        }
    }

    public static String AffplanTable(Participant participant){
        String plan ="";
        String sautLigne = System.getProperty("line.separator");
        if(participant instanceof Etudiant){
            for(Map.Entry<Integer, Integer> entry: TableEtu.entrySet()) {
               plan += "Table " + entry.getKey() + ": ";
               plan += entry.getValue() + " place(s) libre " + sautLigne;
            }
        }
        else{
            for(Map.Entry<Integer, Integer> entry: TableP.entrySet()) {
                plan += "Table " + entry.getKey() + ": ";
                plan += entry.getValue() + " place(s) libre " + sautLigne;
            }

        }
        return plan;

    }
}
