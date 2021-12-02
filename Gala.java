package projet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

class Gala implements Serializable {
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
            ajouter_table(new Table(j, 8, "etudiant"));
        }

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
}

