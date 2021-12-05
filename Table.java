package projet;

import java.io.Serializable;

public class Table implements Serializable,Comparable {

    String type;
    int numero_table;
    int place_libre; //8 places libres
    String[] noms_des_participants;

    public Table(int numero_table,int place_libre,String type){
        this.numero_table=numero_table;
        this.place_libre=place_libre;
        this.type=type;
        noms_des_participants=new String[8];
    }

    public void enleverUnePlaceLibre(){
        numero_table-=1;

    }
    public boolean inscrire_nom(String nom){
        //Je parcours le tableau jusqu'à trouver un emplacement libre
        for(int i=0;i<8;i++){
            if(noms_des_participants[i]==null){
                noms_des_participants[i]=nom;
                place_libre-=1;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String retour="";
        retour+=("numero de table :"+numero_table+"\n\r");
        retour+=("type de table"+type+"\n\r");
        retour+=("nombre de places libres"+place_libre+"\n\r");
        for(String nom:noms_des_participants){
            retour+="les noms des participants : "+nom+" ";
        }
        return retour;




    }

    public void calcul_place() {
        if (place_libre == 0) {
            numero_table += 1;
            place_libre = 8;
        } else {
            place_libre -= 1;
        }
    }


    @Override
    public int compareTo(Object o) {
        Table t=(Table)o;
        return this.numero_table-t.numero_table;
    }
}
