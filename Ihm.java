package Projetpoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

/*
//inscription et désincription
class GtGala implements ActionListener
{
    JFrame frame = new JFrame("Gestion Gala");

    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);


    // Définir les boutons
    JButton btn1 = new JButton("inscription");
    JButton btn2 = new JButton("désincription");

    public GtGala() {

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
            choixtype fen3 = new choixtype();
        }
        if(e.getSource()==btn2){
            System.out.println("Bouton 2");
        }
    }
}*/

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



    // Définir les boutons
    JTextField num = new JTextField(7);
    /*JButton btn1 = new JButton("0");
    JButton btn2 = new JButton("1");
    JButton btn3 = new JButton("2");
    JButton btn4 = new JButton("3");
    JButton btn5 = new JButton("4");
    JButton btn6 = new JButton("5");
    JButton btn7 = new JButton("6");
    JButton btn8 = new JButton("7");
    JButton btn9 = new JButton("8");
    JButton btn10 = new JButton("9");*/
    JButton btn11 = new JButton("OK");




    public EntreeNum(String type) {

        JLabel label = new JLabel("Composez votre numéro " + type, JLabel.CENTER);

        // Définissez le frame

        frame.add(label);

        // Définissez le panel
        JPanel panel = new JPanel();

        // Ajouter les boutons au frame
        /*panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btn10);*/
        panel.add(num);
        panel.add(btn11);


        // Ajouter label et panel au frame

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        /*btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);*/
        num.addActionListener(this);
        btn11.addActionListener(this);


        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*String num ="";
        if(e.getSource()==btn1){
            num +="1";
        }
        else if(e.getSource()==btn2){
            num+="2";
        }
        else if(e.getSource()==btn3){
            num+="3";
        }
        else if(e.getSource()==btn4){
            num+="4";
        }
        else if(e.getSource()==btn5){
            num+="5";
        }
        else if(e.getSource()==btn6){
            num+="6";
        }
        else if(e.getSource()==btn7){
            num+="7";
        }
        else if(e.getSource()==btn8){
            num+="8";
        }
        else if(e.getSource()==btn9){
            num+="9";
        }
        else if(e.getSource()==btn10){
            num+="1";

        }
        else*/
        String getValue = num.getText();

        if(e.getSource()==btn11){
            if(getValue.length()==7) {
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
            verification fen5 = new verification(AffNum.numeroetu);
        }
        else if (e.getSource() == btn2) {
            frame.setVisible(false);
            EntreeNum fen5 = new EntreeNum("étudiant");
        }

    }
}


class verification {

    public verification(int num) {
        if (true) {//etudiant non inscrit
            MenuInscription fen6 = new MenuInscription(num);

        }else if (false) {//etudiant inscrit
            Etudiant etu = new Etudiant("nom", "prenom","0000000000","etu@etu.fr",111,1);
            if (true){//date now > date gala + 1 mois
                Menu2 fen6 = new Menu2(etu);
            }
            else {//1 mois avant la date du gala
                Menu3 fen6 = new Menu3(etu);
            }

        }else {//num inconnu
            MessageErreurNumInc fen6 = new MessageErreurNumInc();
        }
    }
}


class MenuInscription implements ActionListener {
    int numero;

    JFrame frame = new JFrame("Inscription");
    JLabel label = new JLabel("Vous n'êtes pas inscrit, choisissez une option :", JLabel.CENTER);

    JButton btn1 = new JButton("s'inscrire");
    JButton btn2 = new JButton("quitter");

    public MenuInscription(int numero) {

        this.numero=numero;

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
            Etudiant etu = new Etudiant("nom", "prenom","0000000000","etu@etu.fr",numero,1);
            Menu1 fen5 = new Menu1(etu);
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
        if(e.getSource()==btn1){
            frame.setVisible(false);
            ConfirmReserv fen11 = new ConfirmReserv(etudiant);
           // AffnbPlace fen9 = new AffnbPlace();
        }
        if(e.getSource()==btn2){
            frame.setVisible(false);
            ChoixDes fen11 = new ChoixDes(etudiant);// Appeler methode desinscritpion table
        }
        else if(e.getSource()==btn3){
            System.out.println("Fermeture de l'application ...");
            frame.setVisible(false);
        }
    }
}

class Menu3 implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion Gala");
    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);

    JButton btn1 = new JButton("Gérer réservation");
    JButton btn2 = new JButton("Se désinscrire");
    JButton btn3 = new JButton("Quitter");

    public Menu3(Etudiant etudiant) {
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
            ConfirmReserv fen11 = new ConfirmReserv(etudiant);
            // AffnbPlace fen9 = new AffnbPlace();
        }
        if(e.getSource()==btn2){
            frame.setVisible(false);
            ChoixDes fen11 = new ChoixDes(etudiant);// Appeler methode desinscritpion table
        }
        else if(e.getSource()==btn3){
            System.out.println("Fermeture de l'application ...");
            frame.setVisible(false);
        }
    }
}



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
            //plan table
            ChoixTable fen16 = new ChoixTable(etudiant);

        }
        if(e.getSource()==btn2){
            frame.setVisible(false);
            MessageChoixauto fen13 = new MessageChoixauto(5); // mettre la variable nb table

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
            if (getValue.equals("1") || getValue.equals("2") || numtable>15 || numtable<0){
                frame.setVisible(false);
                MessageErreurChoixTable fen18 = new MessageErreurChoixTable(etudiant);
            }
            else{
                frame.setVisible(false);
                MessageConfirm fen18 = new MessageConfirm(numtable,etudiant);}



        }
    }
}



class VerifAnnee {
    public VerifAnnee(Etudiant etu){
        if(etu.numero_etu == 5){ //si etu 5 annee
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



/*
class CheckDate {

    public boolean CheckDate() {

        if () { //si date = un mois avant gala
            return true;

        } else if () {
            return false;
        }
    }
}*/

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
    JButton btn1 = new JButton("OK");

    public ChoixDes(Etudiant etudiant) {
        this.etudiant = etudiant;

        JLabel label = new JLabel("Veuillez rentrer votre numéro de table", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();
        panel.add(numTable);
        panel.add(btn1);

        frame.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
        numTable.addActionListener(this);
        btn1.addActionListener(this);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numTabl = numTable.getText();

        if (e.getSource() == btn1) {
            if(false){ // mettre methode de desinscritption qui retourne un boolean
                frame.setVisible(false);
                MessageConfirmDes fen15 = new MessageConfirmDes();
            }
            else{
                frame.setVisible(false);
                MessageErreurDes fen15 = new MessageErreurDes(etudiant);
            }

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



    public MessageConfirmDes() {

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
        }
    }
}

class MessageChoixauto implements ActionListener {
    JFrame frame = new JFrame("Gestion reservation");

    JButton btn1 = new JButton("OK");




    public MessageChoixauto(int nbtable) {
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
        }
    }
}

class MessageConfirm implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("Retour à l'acceuil");

    public MessageConfirm(int nbtable, Etudiant etudiant) {
        this.etudiant=etudiant;

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
            Menu2 fen17 = new Menu2(etudiant);
        }
    }
}

class MessageErreurDes implements ActionListener {
    Etudiant etudiant;

    JFrame frame = new JFrame("Gestion reservation");
    JButton btn1 = new JButton("OK");

    public MessageErreurDes(Etudiant etudiant) {
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






