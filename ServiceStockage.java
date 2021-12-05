package projet;
import java.io.*;

public class ServiceStockage implements IServiceStockage{
    private File f;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    /**
     * Crée un objet de type ServiceStockage qui va accéder à un fichier "gala.ser" en lecture et en écriture.
     * Le fichier "gala.ser" est créé s'il n'existe.
     * @throws IOException Erreur liée aux entrées/sorties
     */
    public ServiceStockage() throws IOException {
        f = new File("C:\\Quentin\\L2 Info\\POO\\Projet java\\gala.ser");
        f.createNewFile();
        fis = new FileInputStream(f);

    }

    /**
     * Ecrit l'objet passé en paramètre dans le fichier à condition que la classe de l'objet implémente l'interface Serializable
     * @param object
     * @throws IOException Erreur liée aux entrées/sorties
     */
    @Override
    public void enregistrer(Object object) throws IOException {
      try {
          fos = new FileOutputStream(f);
          oos = new ObjectOutputStream(fos);
          oos.writeObject(object);
      }
        finally{
                oos.close();
                fos.close();
            }

    }

    /**
     * Lit un objet dans le fichier à condition que la classe de l'objet implémente l'interface Serializable
     * @return l'objet lu
     * @throws IOException Erreur liée aux entrées/sorties
     * @throws ClassNotFoundException La classe d'un objet sérialisé ne peut être trouvée.
     */
    @Override
    public Object charger(){
        Object o = null;
        try {
            ois = new ObjectInputStream(fis);
            o = ois.readObject();
        } catch(EOFException e){
            System.out.println("Fin de lecture du Gala enregistré");
        } catch (IOException | ClassNotFoundException e ) {
            System.out.println("erreur dans le chargement"+e);
        }
        return o;
    }
}
