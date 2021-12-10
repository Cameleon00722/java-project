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
    /*
    public boolean ajouter_participant(Participant invited){
        if (place_libre > 0){
            place_libre -= 1;
            if(invited instanceof Etudiant) {
                return invite.add(String.valueOf(((Etudiant) invited).numero_etu));
            }
            else{
                return invite.add(String.valueOf(((Personnel) invited).numero));
            }
        }
        else{
            System.out.println("Table remplie");
            return false;
        }
    }

    public boolean ajouter(String invit){ //pour accompagnant
        if (place_libre > 0){
            place_libre -= 1;
            return invite.add(invit);
        }
        else{
            System.out.println("Table remplie");
            return false;
        }
    }
    /**
     * @param invited - l'élément que l'on veut supprimer
     * @throws Exception - si le paramètre n'est pas inscrit à la table
     */
    /*
    public boolean supprimerParticpant(Participant invited){
        if(invited instanceof Etudiant) {
            if (invite.contains(String.valueOf(((Etudiant) invited).numero_etu))) {
                return invite.remove(String.valueOf(((Etudiant) invited).numero_etu));
            } else {
                throw new IllegalArgumentException("Le participant doit être inscrit à la table");
            }
        }
        else{
                if (invite.contains(String.valueOf(((Personnel) invited).numero))) {
                    return  invite.remove(String.valueOf(((Personnel) invited).numero));
                }
                else{
                    throw new IllegalArgumentException("Le participant doit être inscrit à la table");
                }
            }

        }


    public boolean supprimer(String invited){ //pour accompagnant
        if (invite.contains(invited)) {
            return invite.remove(invited);
        }
        else{
            throw new IllegalArgumentException("Le participant doit être inscrit à la table");
        }
    }
    */
}
