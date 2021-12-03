package projet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

class Gala implements Serializable {
    private LocalDate dateDuGala;
    private static final long serialVersionUID = 365769146812169873L;

    //Constantes
    public static final int tarif1 = 10;
    public static final int tarif2 = 15;
    public static final int tarif3 = 20;
    public static final int nb_tables_etudiants = 15;
    public static final int nb_tables_personnels = 15;

    //Les collections
    private Set<Table> lesTables = new TreeSet<>();

    private Set<Etudiant> tous_les_etudiants = new TreeSet<>();
    private Set<Etudiant> etudiants_inscrits = new TreeSet<>();
    private PriorityQueue<Etudiant> etudiants_en_attente = new PriorityQueue<>();
    private Set<Etudiant> etudiants_avec_reservation = new TreeSet<>();

    private Set<Personnel> tous_les_personnels = new TreeSet<>();
    private Set<Personnel> personnels_inscrits = new TreeSet<>();
    private Set<Personnel> personnels_avec_reservation = new TreeSet<>();


    //Constructeur
    public Gala(LocalDate date) {
        //ici une méthode qui va lire les fichiers. Méthode de la classe IHM ?
        //rempli les ensembles
        //appelle des fonctions du modèle, fonction qui lit chauqe ligne du fichier puis ajoute la ligne à l'ensemble
        for (int i = 0; i < 15; i++) {
            ajouter_table(new Table(i, 8, "etudiant"));
        }
        for (int j = 15; j < 25; j++) {
            ajouter_table(new Table(j, 8, "personnel"));
        }
        this.dateDuGala=date;
    }

    //Methode liées aux tables
    public boolean ajouter_table(Table table) {
        return lesTables.add(table);
    }

    public String afficher_tables() {
        String tout = "";
        for (Table t : lesTables) {
            tout += t.toString();
        }
        return tout;
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



