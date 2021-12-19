package Projetpoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//choix etu ou personel
public class choixtype implements ActionListener
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

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            frame.setVisible(false);
            Code fen3 = new Code();
        }
    }
}
