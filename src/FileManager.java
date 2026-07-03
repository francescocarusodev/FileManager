import javax.swing.text.StringContent;
import java.io.*;

public class FileManager {

    public void scriviSuFile(String pathFile, String contenuto) {
        File file = new File(pathFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Il file non esiste, l'ho appena creato!");
            } catch (IOException ex) {
                System.out.println("Errore : " + ex);
            }

        }

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile))
        ) {
            bw.write(contenuto);
            System.out.println("File modificato correttamente");
        } catch (IOException ex) {
            System.out.println("Errore : " + ex);
        }
    }




    public void leggiDaFile(String pathFile) {
        File file = new File(pathFile);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
                String fileLetto;
                System.out.println("Il file contiene: ");
                while ((fileLetto = br.readLine()) != null) {
                    System.out.print(fileLetto);
                }
                System.out.println();
            } catch (IOException ex) {
                System.out.println("Errore : " + ex);
            }
        } else {
            System.out.println("Il file non esiste");
        }
    }



    public void copiaFile(String sorgente, String destinazione) {
        File fileSorgente = new File(sorgente);
        File fileDestinazione = new File(destinazione);
        if (fileDestinazione.exists() & fileSorgente.exists()) {
            try (
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sorgente));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinazione));
            ) {
                byte[] buffer = new byte[1024];
                int bytesLetti;
                while ((bytesLetti = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesLetti);
                }
                System.out.println("File copiato");
            } catch (IOException ex) {
                System.out.println("Errore : " + ex);
            }
        } else {
            System.out.println("uno dei due file non esiste");
        }
    }



    public void eliminaFile(String pathFile) {
        File file = new File(pathFile);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Il file è stato eliminato");
            } else {
                System.out.println("Impossibile eliminare il file");
            }
        } else {
            System.out.println("Il file non esiste");
        }
    }

    public void creaFile(String pathFile) {
        File file = new File(pathFile);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Il file è stato creato");
                } else {
                    System.out.println("Impossibile creare il file");
                }
            } else {
                System.out.println("Il file esiste già");
            }
        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}
