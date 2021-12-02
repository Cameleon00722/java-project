package projet;

import java.io.Serializable;

public class Etudiant extends Participant implements Serializable,Comparable {

    int numero_etu;
    byte annee_formation; //étant compris entre 1 et 5 pour limiter la ram usage

    public Etudiant(String nom, String prenom, String telephone, String mail, int numero_etu, byte annee_formation) {
        super(nom, prenom, telephone, mail);
        this.numero_etu = numero_etu;
        this.annee_formation = annee_formation;
    }

    @Override
    public int compareTo(Object o) {
        Etudiant e = (Etudiant) o;
        return this.numero_etu-e.numero_etu;
    }
        /*public void reader(String args[])
        {
            String type = "student";
            try
            {
                // Le fichier d'entrée
                FileInputStream file = new FileInputStream("etudiant.txt");
                Scanner scanner = new Scanner(file);

                //renvoie true s'il y a une autre ligne à lire
                while(scanner.hasNextLine() && scanner != type)
                {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }*/
}
