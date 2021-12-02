package Projetpoo;

import javax.swing.*;
import java.awt.*;

public class Ihm
{
    public static void main(String[] args)
    {
        // Définissez le frame
        JFrame frame = new JFrame("Gestion Gala");

        JLabel label = new JLabel("Choisissez une option", JLabel.CENTER);
        frame.add(label);

        // Définissez le panel
        JPanel panel = new JPanel();

        // Définir les boutons
        JButton btn1 = new JButton("inscription");
        JButton btn2 = new JButton("désincription");

        // Ajouter les boutons au frame
        panel.add(btn1);
        panel.add(btn2);

        // Ajouter label et panel au frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);

        frame.pack();
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
