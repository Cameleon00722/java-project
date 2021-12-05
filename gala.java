package projet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

class Gala implements Serializable {
    private LocalDate dateDuGala;
    public int version;


    //Constantes
    public static final int tarif1 = 10;
    public static final int tarif2 = 15;
    public static final int tarif3 = 20;
    public static final int nb_tables_etudiants = 15;
    public static final int nb_tables_personnels = 15;

    //Les collections
    //private Set<Table> lesTables = new TreeSet<>();
    private Table[] lesTables=new Table[25];

    private Set<Etudiant> tous_les_etudiants = new TreeSet<>();
    private Set<Etudiant> etudiants_inscrits = new TreeSet<>();
    private PriorityQueue<Etudiant> etudiants_en_attente = new PriorityQueue<>();
    private Set<Etudiant> etudiants_avec_reservation = new TreeSet<>();

    private Set<Personnel> tous_les_personnels = new TreeSet<>();
    private Set<Personnel> personnels_inscrits = new TreeSet<>();
    private Set<Personnel> personnels_avec_reservation = new TreeSet<>();


    //Constructeur
    public Gala(LocalDate date) {

        //charger_tous_les_etudiants("C:\\Quentin\\L2 Info\\POO\\RessourcesProjetPOO2021_2022\\etudiants.txt");
        charger_tous_les_personnels("C:\\Quentin\\L2 Info\\POO\\RessourcesProjetPOO2021_2022\\personnel.txt");

        for (int i = 0; i < 15; i++) {
            lesTables[1]=new Table(i, 8, "étudiant");
        }
        for (int j = 15; j < 25; j++) {
            lesTables[j]=new Table(j, 8, "personnel");
        }
        this.dateDuGala=date;
    }
    void charger_tous_les_etudiants(String chemin_du_fichier_txt) {
        try{
            File lectureEtudiants = new File(chemin_du_fichier_txt);
            Scanner lecEtu= new Scanner(lectureEtudiants);
            while(lecEtu.hasNextLine()){
                String str=lecEtu.nextLine();
                str=str.replaceAll( "\\s"," ");

                String[] words=str.split(" ");
                String numero_etu=words[0];
                String nom=words[1];
                String prenom=words[2];
                String tel=words[3];
                String mail=words[4];
                String annee=words[5];

                Etudiant cobaye = new Etudiant(nom,prenom,tel,mail,Integer.parseInt(numero_etu),Byte.parseByte(annee));
                tous_les_etudiants.add(cobaye);
            }
            lecEtu.close();

        }catch(FileNotFoundException e){
            System.out.println(e);
        }

    }
    void charger_tous_les_personnels(String chemin_du_fichier_txt) {
        try{
            File lecturePersonnels = new File(chemin_du_fichier_txt);
            Scanner lecPer = new Scanner(lecturePersonnels);
            while(lecPer.hasNextLine()){

                String str=lecPer.nextLine();
                str=str.replaceAll( "\\s"," ");

                String[] words=str.split(" ");
                String numero_id=words[0];
                String nom=words[1];
                String prenom=words[2];
                String tel=words[3];
                String mail=words[4];

                Personnel cobaye = new Personnel(nom,prenom,tel,mail,Integer.parseInt(numero_id));
                tous_les_personnels.add(cobaye);
            }
            lecPer.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }


    //Methode liées aux tables
    public String afficher_tables() {
        String tout = "";
        for (Table t : lesTables) {
            tout += t.toString();
        }
        return tout;
    }
    //Méthode liéees aux réservation
    public Reservation reserver_une_table(LocalDate date, int num_table, int nbr_place, double montant,Participant participant,int numero_de_table,int nb_accompagnant){
        Reservation reservation = new Reservation(date,num_table,nbr_place,montant);
        lesTables[numero_de_table-1].inscrire_nom(participant.getNom());
        for(int i=0;i<nb_accompagnant;i++){
            lesTables[numero_de_table-1].inscrire_nom("+accompagnant");
        }
        return reservation;
    }

    //Ajout des etudiants dans les collections
    boolean ajouter_etudiant(Etudiant etu){
        return tous_les_etudiants.add(etu);
    }
    boolean ajouter_etudiant_aux_inscrits(Etudiant etu){
        return etudiants_inscrits.add(etu);
    }
    boolean ajouter_etudiant_en_attente(Etudiant etu){
        return etudiants_en_attente.add(etu);
    }
    boolean ajouter_etudiant_avec_reservation(Etudiant etu){
        return etudiants_avec_reservation.add(etu);
    }

    //Suppression des étudiants des collections
    boolean supprimer_etudiants_des_inscrits(Etudiant etu){
        return etudiants_inscrits.remove(etu);
    }
    boolean supprimer_etudiant_en_attente(Etudiant etu){
        return etudiants_en_attente.remove(etu);
    }
    boolean supprimer_etudiant_avec_reservation(Etudiant etu){
        return etudiants_avec_reservation.remove(etu);
    }

    //Transfert des etudiants entre les listes
    boolean transferer_etudiant_en_attente_vers_confirme(){
        if(etudiants_en_attente.isEmpty()){
            return false;
        }
        ajouter_etudiant_avec_reservation(etudiants_en_attente.remove());
        return true;
    }

    //Ajout des personnels dans les collections
    boolean ajouter_personnel(Personnel personnel){
        return tous_les_personnels.add(personnel);
    }
    boolean ajouter_personnel_aux_inscrits(Personnel personnel){
        return personnels_inscrits.add(personnel);
    }
    boolean ajouter_personnel_avec_reservation(Personnel personnel){
        return personnels_avec_reservation.add(personnel);
    }

    //Suppression des personnels des collections
    boolean supprimer_personnel_des_inscrits(Personnel personnel){
        return personnels_inscrits.remove(personnel);
    }
    boolean supprimer_presonnel_avec_reservation(Personnel personnel){
        return personnels_avec_reservation.remove(personnel);
    }





}



