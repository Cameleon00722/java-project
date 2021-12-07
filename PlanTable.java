package projet;

import java.util.*;

public class PlanTable {
    Map<Integer, String> planTable;

    public PlanTable() {
        planTable = new HashMap<>();
    }

    public boolean supprimer(Integer numtable, String participant){
        return planTable.remove(numtable,participant);
    }

    public boolean ajouter(Table table, Participant p) {
        if (p.est_accompagné()) {
            if ((p.nb_accompagnant()) + 1< table.place_libre) {
                planTable.put(table.numero_table,p.prenom);
                table.place_libre-=1;
                for(String i: p.accompagnant) {
                    planTable.put(table.numero_table,i);
                    table.place_libre-=1;
                }
                return true;
            }
        }
        else if ( table.place_libre >= 1){
            planTable.put(table.numero_table,p);
            table.place_libre-=1;

            return true;
        }
        return false;
    }

    public Iterator<Integer> table() {
        Set<Integer> numtable = planTable.keySet();
        return numtable.iterator();
    }

    public String afficherPlanTables() {
        String plan = "";

        Set<Map.Entry<Integer, String>> lesTables= planTable.entrySet();
        Iterator<Map.Entry<Integer, String>> it = lesTables.iterator();

        while (it.hasNext()){
            Map.Entry<Integer, String> uneTable = it.next();
            plan = plan+uneTable.toString()+ "\n";
        }
        return plan;
    }

    public String plan(Integer i){
        return planTable.get(i);
    }


    /*public Set<Integer> planTable(Integer i){
        Set<Integer> table = new HashSet<Integer>();
        Iterator<Integer> it = table();
        while (it.hasNext()){
            Integer suivant = it.next();
            if (suivant.getNom().equalsIgnoreCase(i))
                table.add(suivant);
        }
        return table;
    }*/
}
