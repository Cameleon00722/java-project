package projet;

import java.io.Serializable;

public class Etudiant extends Participant implements Serializable,Comparable {

    private int numero_etu;
    private byte annee_formation; //étant compris entre 1 et 5 pour limiter la ram usage

    //Getters et setters
    public byte getAnnee_formation(){
        return annee_formation;
    }

    public int getNumero_etu() {
        return numero_etu;
    }

    public Etudiant(String nom, String prenom, String telephone, String mail, int numero_etu, byte annee_formation) {
        super(nom, prenom, telephone, mail);
        this.numero_etu = numero_etu;
        this.annee_formation = annee_formation;
    }

    @Override
    public int compareTo(Object o) {
        Etudiant e = (Etudiant) o;
        return this.annee_formation-e.annee_formation;
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
