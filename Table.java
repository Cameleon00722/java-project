package projet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Table implements Serializable,Comparable {

    private String type;
    private int numero_table;
    private int place_libre; //8 places libres au départ.
    private Set<String> noms_des_presents;//Etudiants, personnels et accompagnants

    //Constructeur
    public Table(int numero_table,int place_libre,String type){
        this.numero_table=numero_table;
        this.place_libre=place_libre;
        this.type=type;
        noms_des_presents=new HashSet<>();
    }

    //Getters and setters
    public int getNumero_table() {
        return numero_table;
    }
    public int getPlace_libre() {
        return place_libre;
    }

    public void enleverUnePlaceLibre(){
        numero_table-=1;
    }
    public boolean inscrire_nom(String nom){
        //remplacer l'ajout des noms par les numeros
        if(noms_des_presents.add(nom)){
            //au même moment qu'on insert un nom on suspprime une place libre
            place_libre-=1;
            return true;
        }
        return false;
    }
    public boolean retirer_nom(String nom){
        if(noms_des_presents.remove(nom)){
            place_libre+=1;
            return true;
        }
        return false;
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
    public String toString(){
        String retour="";
        retour+=("numero de table :"+numero_table+"\n\r");
        retour+=("type de table"+type+"\n\r");
        retour+=("nombre de places libres"+place_libre+"\n\r");
        for(String nom:noms_des_presents){
            retour+="les noms des participants : "+nom+" ";
        }
        return retour;
    }

    @Override
    public int compareTo(Object o) {
        Table t=(Table)o;
        return this.numero_table-t.numero_table;
    }


    public boolean ajouter_participant(Participant invited){
        if (place_libre > 0){
            place_libre -= 1;
            if(invited instanceof Etudiant) {
                return noms_des_presents.add(String.valueOf(((Etudiant) invited).getNumero_etu()));
            }
            else{
                return noms_des_presents.add(String.valueOf(((Personnel) invited).getNumero()));
            }
        }
        else{
            System.out.println("Table remplie");
            return false;
        }
    }
    public boolean ajouter_accompagnants(Participant participant,int nombre_accompagnateur){ //pour accompagnant
        if (place_libre > 0){
            place_libre -= 1;
            if(participant instanceof Etudiant){
                boolean ajout_valide=false;
                for (int i = 0; i < (nombre_accompagnateur); i++) {
                    String nom_accompagnateur="accompagnateur|"+((Etudiant) participant).getNumero_etu()+"|"+i;
                    ajout_valide=noms_des_presents.add(nom_accompagnateur);
                }
                return ajout_valide;
            }
            if(participant instanceof Personnel){
                boolean ajout_valide=false;
                for (int i = 0; i < (nombre_accompagnateur); i++) {
                    String nom_accompagnateur="accompagnateur|"+((Personnel) participant).getNumero()+"|"+i;
                    ajout_valide=noms_des_presents.add(nom_accompagnateur);
                }
                return ajout_valide;
            }
        }
        else{
            System.out.println("Table remplie");
            return false;
        }return false;
    }
    /**
     * @param invited - l'élément que l'on veut supprimer
     * @throws Exception - si le paramètre n'est pas inscrit à la table
     */
    public boolean supprimerParticpant(Participant invited){
        place_libre+=1;
        if(invited instanceof Etudiant) {
            if (noms_des_presents.contains(String.valueOf(((Etudiant) invited).getNumero_etu()))) {
                return noms_des_presents.remove(String.valueOf(((Etudiant) invited).getNumero_etu()));
            } else {
                throw new IllegalArgumentException("Le participant doit être inscrit à la table");
            }
        }
        if(invited instanceof Personnel){
                if (noms_des_presents.contains(String.valueOf(((Personnel) invited).getNumero()))) {
                    return  noms_des_presents.remove(String.valueOf(((Personnel) invited).getNumero()));
                }
                else{
                    throw new IllegalArgumentException("Le participant doit être inscrit à la table");
                }
            }
        return false;
        }
    public boolean supprimerAccompagnant(Participant invited, int nombre_accompagnateur){ //pour accompagnant
        place_libre += 1;
        if(invited instanceof Etudiant){
            boolean supp_valide=false;
            for (int i = 0; i < (nombre_accompagnateur); i++) {
                String nom_accompagnateur="accompagnateur|"+((Etudiant) invited).getNumero_etu()+"|"+i;
                if (noms_des_presents.contains(nom_accompagnateur))
                supp_valide=noms_des_presents.remove(nom_accompagnateur);
            }
            return supp_valide;
        }
        if(invited instanceof Personnel){
            boolean ajout_valide=false;
            for (int i = 0; i < (nombre_accompagnateur); i++) {
                String nom_accompagnateur="accompagnateur|"+((Personnel) invited).getNumero()+"|"+i;
                if (noms_des_presents.contains(nom_accompagnateur)){
                    ajout_valide=noms_des_presents.remove(nom_accompagnateur);
                }
            }
            return ajout_valide;
        }
        return false;
    }
}
