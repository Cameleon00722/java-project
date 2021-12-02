package projet;

import java.io.Serializable;

public class Table implements Serializable,Comparable {

    String type;
    int numero_table;
    int place_libre; //8 places libres

    public Table(int numero_table,int place_libre,String type){
        this.numero_table=numero_table;
        this.place_libre=place_libre;
        this.type=type;
    }


    @Override
    public String toString(){
        return Integer.toString(numero_table);
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
