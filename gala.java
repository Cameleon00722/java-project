package projet;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Gala implements Serializable {
    private LocalDate dateDuGala;
    public int version;

    //Constantes
    public static final int tarif1 = 10;
    public static final int tarif2 = 15;
    public static final int tarif3 = 20;
    public static final int nb_tables_etudiants = 15;
    public static final int nb_tables_personnels = 10;

    //Les collections
    private Set<Table> lesTables = new TreeSet<>(new Trie_table());
    //private Table[] lesTables=new Table[25];

    private Set<Etudiant> tous_les_etudiants = new TreeSet<>();
    private Set<Etudiant> etudiants_inscrits = new TreeSet<>();
    private PriorityQueue<Etudiant> etudiants_en_attente = new PriorityQueue<>(new Trie_par_annee());
    private Set<Etudiant> etudiants_a_confirmer = new TreeSet<>();
    private Set<Etudiant> etudiants_avec_reservation = new TreeSet<>();

    private Set<Personnel> tous_les_personnels = new TreeSet<>();
    private Set<Personnel> personnels_inscrits = new TreeSet<>();
    private Set<Personnel> personnels_avec_reservation = new TreeSet<>();


    //Constructeur
    public Gala(LocalDate date) {

        charger_tous_les_etudiants("C:\\Quentin\\L2 Info\\POO\\RessourcesProjetPOO2021_2022\\etudiants.txt");
        charger_tous_les_personnels("C:\\Quentin\\L2 Info\\POO\\RessourcesProjetPOO2021_2022\\personnel.txt");

        for (int i = 1; i < nb_tables_etudiants+1; i++) {
            lesTables.add(new Table(i, 8, "étudiant"));
        }
        for (int j = nb_tables_etudiants+1; j < nb_tables_etudiants+nb_tables_personnels+1; j++) {
            lesTables.add(new Table(j, 8, "personnel"));
        }
        this.dateDuGala=date;
    }
    void charger_tous_les_etudiants(String chemin_du_fichier_txt) {
        try{
            File lectureEtudiants = new File(chemin_du_fichier_txt);
            Scanner lecEtu= new Scanner(lectureEtudiants);
            while(lecEtu.hasNextLine()){
                String str=lecEtu.nextLine();
                System.out.println("brut :"+str);
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

    //Classes pour comparer
    public static class Trie_par_annee implements Comparator<Etudiant>, Serializable{

        @Override
        public int compare(Etudiant e1, Etudiant e2) {
            if(e1.getAnnee_formation()< e2.getAnnee_formation()){ return -1; }
            if(e1.getAnnee_formation()> e2.getAnnee_formation()){ return 1; }
            else{ return 0;}
        }
    }
    public static class Trie_table implements Comparator<Table>, Serializable{
        @Override
        public int compare(Table t1,Table t2){
            if(t1.getNumero_table()<t2.getNumero_table()){return -1;}
            if(t2.getNumero_table()>t2.getNumero_table()){return 1;}
            else{
                return 0;
            }
        }
    }


    //Methode pour afficher les ensembles
    public String afficher_tables() {
        String tout = "";
        for (Table t : lesTables) {
            tout += t.toString();
        }
        return tout;
    }
    public void afficher_le_gala(){
        System.out.println("Pour visualiser tous les etudiants : tapez 1");
        System.out.println("Pour visualiser tous les etudiants inscrits : tapez 2");
        System.out.println("Pour visualiser tous les etudiants en attente: tapez 3");
        System.out.println("Pour visualiser tous les etudiants à confirmer : tapez 4");
        System.out.println("Pour visualiser tous les etudiants avec réservation: tapez 5");
        System.out.println("Pour visualiser tous les personnels : tapez 6");
        System.out.println("Pour visualiser tous les personnels inscrits: tapez 7");
        System.out.println("Pour visualiser tous les personnels avec réservation: tapez 8");

        Scanner choix_ensemble= new Scanner(System.in);
        int leChoix=choix_ensemble.nextInt();
        boolean choix_correct=false;
        while(!choix_correct){
            if(leChoix==1){
                for (Etudiant e : tous_les_etudiants) {
                    String tout = "";
                    tout += e.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==2){
                for (Etudiant e : etudiants_inscrits) {
                    String tout = "";
                    tout += e.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==3){
                for (Etudiant e : etudiants_en_attente) {
                    String tout = "";
                    tout += e.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==4){
                for (Etudiant e : etudiants_a_confirmer) {
                    String tout = "";
                    tout += e.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==5){
                for (Etudiant e : etudiants_avec_reservation) {
                    String tout = "";
                    tout += e.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==6){
                for (Personnel p : tous_les_personnels) {
                    String tout = "";
                    tout += p.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==7){
                for (Personnel p : personnels_inscrits) {
                    String tout = "";
                    tout += p.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else if(leChoix==8){
                for (Personnel p : personnels_avec_reservation) {
                    String tout = "";
                    tout += p.toString();
                    System.out.println(tout);
                }
                choix_correct=true;
            }else{
                System.out.println("Mauvaise saisie");
            }
        }



    }

    //Tests de présence dans les ensembles
    public boolean estInscrit(Participant participant){
        return etudiants_inscrits.contains(participant);
    }
    public boolean est_en_attente(Participant participant){
        return etudiants_en_attente.contains(participant);
    }
    public boolean est_à_confirmer(Participant participant){
        return etudiants_a_confirmer.contains(participant);
    }
    public boolean est_titulaire_reservation(Participant participant){
        return etudiants_avec_reservation.contains(participant);
    }

    //Méthode liéees aux réservation
    /**
     *
     * @param date la date
     * @param num_table le numero de table
     * @param nbr_place le nombre de place de la reservation
     * @param participant
     * vérifie si il y a assez de place dans la table pour inserer les participant     *
     */
    public void effectuer_une_reservation(LocalDate date, int num_table, int nbr_place, Participant participant){
        if(assez_de_place(num_table,nbr_place)) {
            int montant=calcul_montant(participant,nbr_place);
            Reservation reservation = new Reservation(date, num_table, nbr_place, montant);
            participant.associer_reservation(reservation);

            for (Table table : lesTables) {
                if (table.getNumero_table() == num_table) {
                    table.ajouter_participant(participant);
                }
            }

            for (Table table : lesTables) {
                if (table.getNumero_table() == num_table) {
                    table.ajouter_accompagnants(participant, reservation.getNombre_accompagnateur());
                }
            }

            if (participant instanceof Etudiant) {
                ajouter_etudiant_avec_reservation((Etudiant) participant);
            }
            if (participant instanceof Personnel) {
                ajouter_personnel_avec_reservation((Personnel) participant);
            }
        }
    }
    public void supprimer_reservation(Participant participant){

            for(Table table:lesTables) {
                if (table.getNumero_table() == participant.getReservation().getNumero_de_table()) {
                    table.supprimerParticpant(participant);
                }
            }
            for(int i=0;i<(participant.getReservation().getNombre_accompagnateur());i++){
                for(Table table:lesTables) {
                    if (table.getNumero_table() == participant.getReservation().getNumero_de_table()) {
                        int a=participant.getReservation().getNombre_accompagnateur();
                        table.supprimerAccompagnant(participant,a);
                    }
                }
            }
            participant.supprimer_reservation();
            /*int table_reservee = participant.reservation.num_table;
            if (participant.est_accompagné()) {
                for (String s : PlanTable.plan(table_reservee)){ // parcourir plan de table
                    for(String acc : participant.accompagnant){
                        if (s.equals(participant.prenom)){ // si on trouve le participant
                            PlanTable.supprimer(table_reservee, participant.prenom);
                        }
                        else if(s.equals(acc)){ // si on trouve un accompagnant du participant
                            PlanTable.supprimer(table_reservee, acc);
                        }
                    }
                }
            }
            else {
                for (String s : PlanTable.plan(table_reservee)) {//parcourir les elements de la table
                    if (s.equals(participant.prenom)) { //si elemnts = particpant ou accompagnateur du participant
                        PlanTable.supprimer(table_reservee, participant.prenom); //supprimer de la table
                    }
                }
            }
            System.out.println("Réservation supprimée");*/
    }

    public int calcul_montant(Participant participant,int nombre_place_demandees){
        int leMontant=0;
        if(participant instanceof Etudiant){
            Etudiant monEtu= (Etudiant) participant;
            if(monEtu.getAnnee_formation()==5){
                leMontant+=tarif1;
            }else{
                leMontant+=tarif2;
            }
            for(int i=0;i<nombre_place_demandees-1;i++){
                leMontant+=tarif3;
            }
        }
        if(participant instanceof Personnel){
            leMontant+=tarif3;
            for(int i=0;i<nombre_place_demandees-1;i++){
                leMontant+=tarif3;
            }
        }
        return leMontant;
    }
    //contrôle de place disponible avant réservation
    public boolean assez_de_place(int numero_table, int nb_places){
        for(Table table:lesTables){
            if(table.getNumero_table()==numero_table){
                if(table.getPlace_libre()==nb_places){
                    return true;
                }
            }
        }
        return false;
    }

    //Methode de désinscription
    public boolean desinscription_sans_reservation_effective(Participant participant){
        supprimer_reservation(participant);

        if (participant instanceof Etudiant) {
            Etudiant monEtu = (Etudiant) participant;
            if(supprimer_etudiant_des_inscrits(monEtu)||supprimer_etudiant_en_attente(monEtu)||supprimer_etudiant_a_confirmer(monEtu)){
                return true;
            }
        }
        if (participant instanceof Personnel) {
            Personnel monPer = (Personnel) participant;
            if(supprimer_personnel_des_inscrits(monPer)){
                return true;
            }
        }
        return false;
    }
    public boolean desinscription_avec_reservation_effective(Participant participant){
        LocalDate aujourd_hui = LocalDate.now();
        long delai = ChronoUnit.DAYS.between(dateDuGala,aujourd_hui);
        if(delai>10){
            if (participant instanceof Etudiant) {
                Etudiant monEtu = (Etudiant) participant;
                supprimer_etudiant_avec_reservation(monEtu);
                return true;
            }
            if (participant instanceof Personnel) {
                Personnel monPer = (Personnel) participant;
                supprimer_personnel_avec_reservation(monPer);
                return true;
            }
        }
        return false;
    }

    //fonctions pour connaître le remplissage des tables
    public Set<Table> getLesTables(){
        return lesTables;
    }
    public int nombre_place_possible(Participant participant){
        int nombre_place=0;
        if(participant instanceof Personnel){
            nombre_place=2;
        }
        if(participant instanceof Etudiant){
            Etudiant monEtu= (Etudiant) participant;
            if(monEtu.getAnnee_formation()==5){
                nombre_place=4;
            }else{
                nombre_place=2;
            }
        }
        return nombre_place;
    }

    //methode renvoyer la liste des etudiants

    //Ajout des étudiants dans les collections
    boolean ajouter_etudiant(Etudiant etu){
        return tous_les_etudiants.add(etu);
    }
    boolean ajouter_etudiant_aux_inscrits(Etudiant etu){
        return etudiants_inscrits.add(etu);
    }
    boolean ajouter_etudiant_en_attente(Etudiant etu){
        return etudiants_en_attente.add(etu);
    }
    boolean ajouter_etudiant_a_confirmer(Etudiant etu) {return etudiants_a_confirmer.add(etu);}
    boolean ajouter_etudiant_avec_reservation(Etudiant etu){
        return etudiants_avec_reservation.add(etu);
    }

    //Suppression des étudiants des collections
    boolean supprimer_etudiant_des_inscrits(Etudiant etu){
        return etudiants_inscrits.remove(etu);
    }
    boolean supprimer_etudiant_en_attente(Etudiant etu){
        return etudiants_en_attente.remove(etu);
    }
    boolean supprimer_etudiant_a_confirmer(Etudiant etu) { return etudiants_a_confirmer.remove(etu);}
    boolean supprimer_etudiant_avec_reservation(Etudiant etu){
        return etudiants_avec_reservation.remove(etu);
    }

    //Transfert des etudiants entre les listes
    boolean transferer_etudiant_en_attente_vers_a_confirmer(){
        if(etudiants_en_attente.isEmpty()) {
            return false;
        }
        Etudiant monEtu=etudiants_en_attente.poll();
        return ajouter_etudiant_a_confirmer(monEtu);
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
    boolean supprimer_personnel_avec_reservation(Personnel personnel){
        return personnels_avec_reservation.remove(personnel);
    }
    
    public static Etudiant rechercheetunum(int numeroetu) {
        Iterator<Etudiant> iterator = tous_les_etudiants.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNumero_etu() == numeroetu) {
                return iterator.next();
            }

        }
        return null;
    }





}



