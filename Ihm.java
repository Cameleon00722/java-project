package projet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Scanner;

class Ihm {

    public Ihm() {
        boolean valide = false;
        while (!valide) {

            System.out.print("entrer jour : ");
            Scanner jours = new Scanner(System.in);
            int day = jours.nextInt();

            if (day > 0 && day < 32) {
                System.out.print("entrer mois: ");
                Scanner mois = new Scanner(System.in);
                int mounth = mois.nextInt();

                if (mounth > 0 && mounth < 12) {
                    valide = true;
                    System.out.println("Date du Gala : " + day + "/" + mounth + "/2021");
                    Choixtype fen1 = new Choixtype();
                } else {
                    System.out.println("mois invalide ");
                }
            } else {
                System.out.println("jour invalide ");
            }
        }
    }

    public static void main(String[] args){

        try {
            Ihm try1 = new Ihm();
        }
        catch(Exception e){
            System.out.println("La valeur rentrée n'était pas un chiffre");
        }

    }

}

class Choixtype implements ActionListener {
    JFrame frame = new JFrame("Gestion Gala");

    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);


    // Définir les boutons
    JButton btn1 = new JButton("etudiant");
    JButton btn2 = new JButton("personel");

    public Choixtype() {

        // Définissez le frame

        frame.add(label);

        // Définissez le panel
        JPanel panel = new JPanel();

        // Ajouter les boutons au frame
        panel.add(btn1);
        panel.add(btn2);

        // Ajouter label et panel au frame

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            EntreeNum fen4 = new EntreeNum("étudiant");
        }
        if(e.getSource()==btn2){
            frame.setVisible(false);
            EntreeNum fen4 = new EntreeNum("personnel");

        }
    }
}


class EntreeNum implements ActionListener {
    JFrame frame = new JFrame("Gestion Gala");

    JTextField num = new JTextField(7);
    JButton btn11 = new JButton("OK");

    public EntreeNum(String type) {

        JLabel label = new JLabel("Composez votre numéro " + type, JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();

        panel.add(num);
        panel.add(btn11);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        num.addActionListener(this);
        btn11.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = num.getText();
        if(e.getSource()==btn11){
            if(getValue.length()==7 && getValue.matches("[+-]?\\d*(\\.\\d+)?")) {
                frame.setVisible(false);
                AffNum fen4 = new AffNum(getValue);
            }
            else{
                frame.setVisible(false);
                MessageErreurNum fen4 = new MessageErreurNum();
            }
        }
    }
}

class AffNum implements ActionListener {
    private static int numeroetu;
    JFrame frame = new JFrame("Inscription");


    // Définir les boutons
    JButton btn1 = new JButton("OUI");
    JButton btn2 = new JButton("NON");

    public AffNum(String num) {

        this.numeroetu = Integer.parseInt(num);

        JLabel label = new JLabel("Confirmer numéro étudiant: " + num, JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();

        panel.add(btn1);
        panel.add(btn2);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Etudiant etudiant = Gala.rechercheetunum(numeroetu);
            verification fen5 = new verification(etudiant);
        }
        else if (e.getSource() == btn2) {
            frame.setVisible(false);
            EntreeNum fen5 = new EntreeNum("étudiant");
        }

    }
}


class verification {

    public verification(Etudiant etudiant) {
        if (!(Gala.estInscrit(etudiant)) || !Gala.est_en_attente(etudiant) || !Gala.est_à_confirmer(etudiant) || etudiant.reservation==null) { //n'est pas inscrit pas en attente pas a consfirmer oou n'a pas de reservation on linscrit
            MenuInscription fen6 = new MenuInscription(etudiant);

        }else if (Gala.estInscrit(etudiant)) {//etudiant inscrit
            Menu2 fen6 = new Menu2(etudiant);
        }

        else {//num inconnu
            MessageErreurNumInc fen6 = new MessageErreurNumInc();
        }
    }
}



class MenuInscription implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Inscription");
    JLabel label = new JLabel("Vous n'êtes pas inscrit, choisissez une option :", JLabel.CENTER);

    JButton btn1 = new JButton("s'inscrire");
    JButton btn2 = new JButton("quitter");

    public MenuInscription(Etudiant etudiant) {

        this.etudiant=etudiant;

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);
        panel.add(btn2);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            System.out.println("Inscription ....");
            Gala.ajouter_etudiant_aux_inscrits(etudiant);
            Menu1 fen5 = new Menu1(etudiant);
        }
        if(e.getSource()==btn2){
            System.out.println("Fermeture de l'application ...");
            frame.setVisible(false);
        }
    }
}

class Menu1 implements ActionListener {
    JFrame frame = new JFrame("Gestion Gala");

    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);

    // Définir les boutons
    JButton btn1 = new JButton("Gérer les places du dîner");
    JButton btn2 = new JButton("Se désinscrire");
    JButton btn3 = new JButton("Quitter");

    Etudiant etudiant;

    public Menu1(Etudiant etudiant) {

        this.etudiant = etudiant;

        frame.add(label);

        // Définissez le panel
        JPanel panel = new JPanel();

        // Ajouter les boutons au frame
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        // Ajouter label et panel au frame

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            VerifAnnee fen5 = new VerifAnnee(etudiant);
        }
        if(e.getSource()==btn2){
            frame.setVisible(false);
            ChoixDes fen16 = new ChoixDes(etudiant); // Appeler methode desinscritpion table
        }
        else if(e.getSource()==btn3){
            System.out.println("Fermeture de l'application ...");
            frame.setVisible(false);
        }
    }
}

class Menu2 implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion Gala");
    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);

    JButton btn1 = new JButton("Gérer réservation");
    JButton btn2 = new JButton("Se désinscrire");
    JButton btn3 = new JButton("Quitter");

    public Menu2(Etudiant etudiant) {
        this.etudiant = etudiant;

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate dateaujourdhui = LocalDate.now();

        if (e.getSource() == btn1) {
            frame.setVisible(false);
            if (!(dateaujourdhui.isAfter(dateaujourdhui)) ) {//remplacer dateaujourdhui entre parenthese part date du gala -1mois
                if (Gala.est_en_attente(etudiant)){//Soit il a fait une demande et il est en attente du coup on lui montre sa place
                    AffnbPlace fen9 = new AffnbPlace(etudiant.nb_accompagnant + 1, etudiant);
                }
                else if(Gala.est_à_confirmer(etudiant)) {// soit il est a confirmer donc on lui affiche la frame pour confirmer
                    ConfirmReserv fen9 = new ConfirmReserv(etudiant);
                }
                else if (Gala.estInscrit(etudiant)) {// soit il n'a pas fait de demande de reservation donc on met le frame demande de reservatiopn
                    VerifAnnee fen9 = new VerifAnnee(etudiant);
                }
                else{// soit il a une reservation et on lui montre sa reservation
                    AffReserv fen9 = new AffReserv(etudiant);
                }
            } else{
                if (Gala.est_en_attente(etudiant)){//Soit il est inscrit du coup on lui montre sa place
                    AffnbPlace fen9 = new AffnbPlace(etudiant.nb_accompagnant + 1, etudiant);
                }
                else if (Gala.estInscrit(etudiant)) {// soit il n'a pas fait de demande de reservation donc on met le frame demande de reservatiopn
                    VerifAnnee fen9 = new VerifAnnee(etudiant);
                }
            }


            if (e.getSource() == btn2) {
                frame.setVisible(false);
                ChoixDes fen11 = new ChoixDes(etudiant);// la frame choix des fait le tri selon le cas de l'etudiant
            } else if (e.getSource() == btn3) {
                System.out.println("Fermeture de l'application ...");
                frame.setVisible(false);
            }
        }
    }
}//menu pour ceux qui sont inscrit



class PlanTable implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JLabel label = new JLabel("Afficher le plan des tables ?", JLabel.CENTER);

    JButton btn1 = new JButton("Oui");
    JButton btn2 = new JButton("Non");

    public PlanTable(Etudiant etudiant) {
        this.etudiant = etudiant;

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);
        panel.add(btn2);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            Plan fen16 = new Plan(etudiant);

        }
        if(e.getSource()==btn2){
            frame.setVisible(false);
            if(GestionTable.ChoixAuto(etudiant,etudiant.nb_accompagnant + 1) != 0){
                MessageChoixauto fen13 = new MessageChoixauto( GestionTable.ChoixAuto(etudiant,etudiant.nb_accompagnant + 1),etudiant); // mettre methode choix automatique de table
            }
            else{
                MessageErreurTableremplie fen13 = new MessageErreurTableremplie(etudiant);
            }

        }
    }
}

class Plan implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("Oui");

    public Plan(Etudiant etudiant) {
        this.etudiant = etudiant;
        JLabel label = new JLabel("Retrouver le plan des tables sous forme n°table: place disponible "  + GestionTable.AffplanTable(etudiant), JLabel.CENTER);

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            //plan table
            ChoixTable fen16 = new ChoixTable(etudiant);

        }
    }
}

class ChoixTable implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JLabel label = new JLabel("Choisissez un numéro de table", JLabel.CENTER);

    JTextField numTable = new JTextField(3);
    JButton btn1 = new JButton("OK");

    public ChoixTable(Etudiant etudiant) {
        this.etudiant=etudiant;

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);
        panel.add(numTable);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        numTable.addActionListener(this);

        frame.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = numTable.getText();
        int numtable = Integer.parseInt(getValue);


        if(e.getSource()==btn1){
            if (/*verifier qu'il y a assez de place */ numtable>25 || numtable<11){
                frame.setVisible(false);
                MessageErreurChoixTable fen18 = new MessageErreurChoixTable(etudiant);
            }
            else{
                frame.setVisible(false);
                MessageConfirm fen18 = new MessageConfirm(numtable,etudiant);}



        }
    }
}

class Tarif implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JLabel label = new JLabel("Total à payer: 20" /*+ Gala.calcul_montant(etudiant,etudiant.nb_accompagnant)*/, JLabel.CENTER);

    JButton btn1 = new JButton("Quitter");


    public Tarif(Etudiant etudiant) {
        this.etudiant = etudiant;

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
        }
    }
}


class VerifAnnee {
    public VerifAnnee(Etudiant etu){
        if(etu.getAnnee_formation() == 5){ //si etu 5 annee
            Choix_place5eannee fen6 = new Choix_place5eannee(etu);

        }
        else{
            Choix_placeetu fen6 = new Choix_placeetu(etu);
        }
    }
}



class Choix_placeetu implements ActionListener {

    JFrame frame = new JFrame("Gestion reservation");
    JLabel label = new JLabel("Choisissez jusqu'à 1 places à reserver", JLabel.CENTER);

    JButton btn1 = new JButton("1");

    Etudiant etudiant;

    public Choix_placeetu(Etudiant etudiant) {

        this.etudiant = etudiant;

        frame.add(label);
        JPanel panel = new JPanel();
        panel.add(btn1);


        // Ajouter label et panel au frame

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            AffnbPlace fen7 = new AffnbPlace(1,etudiant);
            etudiant.nb_accompagnant=1;
            System.out.println(etudiant.toString());
        }
    }
}

class Choix_place5eannee implements ActionListener {
    JFrame frame = new JFrame("Gestion reservation");
    JLabel label = new JLabel("Choisissez jusqu'à 3 places à reserver", JLabel.CENTER);

    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");

    Etudiant etudiant;

    public Choix_place5eannee(Etudiant etudiant) {
        this.etudiant = etudiant;

        frame.add(label);
        JPanel panel = new JPanel();

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            AffnbPlace fen7 = new AffnbPlace(1,etudiant);
            etudiant.nb_accompagnant = 1;
        }
        else if(e.getSource()==btn2){
            frame.setVisible(false);
            AffnbPlace fen7 = new AffnbPlace(2,etudiant);
            etudiant.nb_accompagnant = 2;
        }
        else if(e.getSource()==btn3){
            frame.setVisible(false);
            AffnbPlace fen7 = new AffnbPlace(3,etudiant);
            etudiant.nb_accompagnant = 3;

        }
    }
}

class AffnbPlace implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("Retour à l'acceuil");

    public AffnbPlace(int nb, Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("Vous avez choisi " + nb + " place(s). " + "Votre choix à été pris en compte", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Menu2 fen8 = new Menu2(etudiant);


        }
    }
}

class AffReserv implements ActionListener {
    Etudiant etudiant;
    String sautLigne = System.getProperty("line.separator");


    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("Retour à l'acceuil");

    public AffReserv(Etudiant etudiant) {
        this.etudiant = etudiant;



        JLabel label = new JLabel("Information concernant votre reservation : "+ sautLigne, JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Menu2 fen8 = new Menu2(etudiant);


        }
    }
}


class ConfirmReserv implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");

    JButton btn1 = new JButton("Confirmer");
    JButton btn2 = new JButton("Se desinscrire");


    public ConfirmReserv(Etudiant etudiant) {
        this.etudiant= etudiant;

        JLabel label = new JLabel("Votre demande de réservation a été accepté", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);
        panel.add(btn2);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            PlanTable fen12 = new PlanTable(etudiant);
        } else if (e.getSource() == btn2) {
            frame.setVisible(false);
            ChoixDes fen10 = new ChoixDes(etudiant);
        }
    }
}

class ChoixDes implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JTextField numTable = new JTextField(1);
    JButton btn1 = new JButton("Oui");
    JButton btn2 = new JButton("Non");


    public ChoixDes(Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("Se desinscrire?", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);
        panel.add(btn2);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            if(Gala.estInscrit(etudiant)){
                MessageInscritDes fen25 = new MessageInscritDes(etudiant);
            }
            else if(Gala.est_en_attente(etudiant)){
                MessageAttenteDes fen25 = new MessageAttenteDes(etudiant);
            }
            else if(Gala.est_à_confirmer(etudiant)){
                MessageConfirmDes fen25 = new MessageConfirmDes(etudiant);
            }
            else if(Gala.est_titulaire_reservation(etudiant)){
                MessageReservDes fen25 = new MessageReservDes(etudiant);
            }
            else{
                MessageErreurDes fen25 = new MessageErreurDes(etudiant);
            }
        }
        else if (e.getSource() == btn2) {
            frame.setVisible(false);
            Menu2 fen25 = new Menu2(etudiant);
        }
    }
}



class MessageErreurNum implements ActionListener {
    JFrame frame = new JFrame("Connexion");

    JButton btn1 = new JButton("OK");



    public MessageErreurNum() {

        JLabel label = new JLabel("Votre numéro étudiant est invalide", JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            EntreeNum fen20 = new EntreeNum("étudiant");
        }
    }
}

class MessageConfirmDes implements ActionListener {
    JFrame frame = new JFrame("Gestion reservation");

    JButton btn1 = new JButton("OK");
    Etudiant etudiant;


    public MessageConfirmDes(Etudiant etudiant) {
        this.etudiant=etudiant;
        JLabel label = new JLabel("Votre demande de réservation a été supprimé", JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Gala.supprimer_etudiant_a_confirmer(etudiant);
        }
    }
}

class MessageAttenteDes implements ActionListener {
    JFrame frame = new JFrame("Gestion reservation");

    JButton btn1 = new JButton("OK");
    Etudiant etudiant;


    public MessageAttenteDes(Etudiant etudiant) {
        this.etudiant=etudiant;
        JLabel label = new JLabel("Votre demande de réservation a été supprimé", JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Gala.supprimer_etudiant_en_attente(etudiant);
        }
    }
}

class MessageReservDes implements ActionListener {
    Etudiant etudiant;
    JFrame frame = new JFrame("Gestion reservation");

    JButton btn1 = new JButton("OK");

    public MessageReservDes(Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("Votre réservation a été supprimé", JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Gala.supprimer_reservation(etudiant);
            Gala.supprimer_etudiant_avec_reservation(etudiant);
        }
    }
}

class MessageInscritDes implements ActionListener {
    JFrame frame = new JFrame("Gestion reservation");

    JButton btn1 = new JButton("OK");
    Etudiant etudiant;


    public MessageInscritDes(Etudiant etudiant) {
        this.etudiant=etudiant;
        JLabel label = new JLabel("Votre inscription a été supprimé", JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Gala.supprimer_etudiant_des_inscrits(etudiant);
        }
    }
}

class MessageChoixauto implements ActionListener {
    Etudiant etudiant;
    int nbtable;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageChoixauto(int nbtable,Etudiant etudiant) {
        this.etudiant = etudiant;
        this.nbtable = nbtable;
        JLabel label = new JLabel("Votre place a été choisi automatiquement. Vous avez été placé à la table " + nbtable, JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);


        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Gala.effectuer_une_reservation(LocalDate.now(),nbtable,etudiant.nb_accompagnant + 1,etudiant);
            Gala.supprimer_etudiant_a_confirmer(etudiant);
            Tarif fen21 = new Tarif(etudiant);
        }
    }
}

class MessageConfirm implements ActionListener {
    Etudiant etudiant;
    int nbtable;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageConfirm(int nbtable, Etudiant etudiant) {
        this.etudiant=etudiant;
        this.nbtable = nbtable;

        JLabel label = new JLabel("Votre choix a été pris en compte. Vous avez été placé à la table " + nbtable, JLabel.CENTER);
        frame.add(label);
        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Gala.effectuer_une_reservation(LocalDate.now(),nbtable,etudiant.nb_accompagnant + 1,etudiant);
            Gala.supprimer_etudiant_a_confirmer(etudiant);
            Tarif fen17 = new Tarif(etudiant);
        }
    }
}

class MessageErreurDes implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageErreurDes(Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("La desinscription à échoué", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            ChoixDes fen19 = new ChoixDes(etudiant);
        }
    }
}

class MessageErreurChoixTable implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageErreurChoixTable(Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("Numéro de table invalide ", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            ChoixTable fen17 = new ChoixTable(etudiant);
        }
    }
}

class MessageErreurNumInc implements ActionListener {
    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageErreurNumInc() {
        JLabel label = new JLabel("Numéro inconnu ", JLabel.CENTER);

        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            EntreeNum fen19 = new EntreeNum("étudiant");
        }
    }
}

class MessageErreurTableremplie implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageErreurTableremplie(Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("Aucune place disponible ", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        btn1.addActionListener(this);

        frame.pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            frame.setVisible(false);
            Menu2 fen27 = new Menu2(etudiant);
        }
    }
}

