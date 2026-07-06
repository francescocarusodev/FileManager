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
        System.out.println("Info: \nTitolo:" + titolo + ", autore: " + autore + ", contenuto: " + contenuto);
    }



    public void salvaSuFile(String nomeFile){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))){
            oos.writeObject(this);
            System.out.println("Oggetto serializzato!");
        } catch (IOException ex) {
            System.out.println("Errore durante la serializzazione : " + ex);
        }
    }



    public void caricaDaFile(String nomeFile){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))){
                Documento p2 = (Documento) ois.readObject();
                System.out.println("Documento deserializzato con successo.");
                p2.stampaInfo();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Errore durante la deserializzazione: " + ex);
            }
    }
}
