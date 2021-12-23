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
                    System.out.println("jour = " + day + " mois = " + mounth);
                    GtGala fen1 = new GtGala();
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
}
class choixtype implements ActionListener
{
    JFrame frame = new JFrame("Gestion Gala");

    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);


    // Définir les boutons
    JButton btn1 = new JButton("etudiant");
    JButton btn2 = new JButton("personel");

    public choixtype() {

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
            verification fen4 = new verification();
        }
        if(e.getSource()==btn2){
            System.out.println("Bouton 2");
        }
    }
}

class verification{

    public verification() {
        Scanner id = new Scanner(System.in);
        int day = id.nextInt();
        reservation fen5 = new reservation();

    }
}

class reservation implements ActionListener
{
    JFrame frame = new JFrame("Gestion Gala");

    JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);


    // Définir les boutons
    JButton btn1 = new JButton("Gérer les places du dîner");
    JButton btn2 = new JButton("Se désinscrire");

    public reservation() {

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
        }
        if(e.getSource()==btn2){
            System.out.println("Bouton 2");
        }
    }
}
