import java.io.*;

public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titolo;
    private String autore;
    private String contenuto;

    public Documento(String titolo, String autore, String contenuto){
        this.titolo = titolo;
        this.autore = autore;
        this.contenuto = contenuto;
    }

    public void stampaInfo(){
        System.out.println("Titolo:" + titolo + ", autore: " + autore + ", contenuto: " + contenuto);
    }


    @SuppressWarnings("IOStreamConstructor")
    public void salvaSuFile(String nomeFile){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))){
            oos.writeObject(this);
            System.out.println("Oggetto serializzato!");
        } catch (IOException ex) {
            System.out.println("Errore durante la serializzazione : " + ex);
        }
    }


    @SuppressWarnings("IOStreamConstructor")
    public static Documento caricaDaFile(String nomeFile){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))){
                return (Documento) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Errore durante la deserializzazione: " + ex);
            }
        return null;
    }
}
