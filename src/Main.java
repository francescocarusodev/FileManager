import sun.security.krb5.internal.PAData;

import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        String basePath = "C:/Users/Francesco/Desktop/esercizi/FileManager/src/file/";

        //TEST PER LA VERIFICA DELLE FUNZIONALIT° DEI METODI
        /*
        String pathFile = basePath + "file.txt/";
        String pathDestinazione = basePath + "destinazione.txt/";
        String pathDaEliminare = basePath + "fileDaEliminare.txt";
        String pathDaSerializzare = basePath + "Documento.ser";

        FileManager.scriviSuFile(pathFile, "Ho scritto");
        FileManager.leggiDaFile(pathFile);
        FileManager.copiaFile(pathFile, pathDestinazione);
        FileManager.leggiDaFile(pathDestinazione);
        FileManager.eliminaFile(pathDaEliminare);
        FileManager.leggiDaFile(pathDaEliminare);
        FileManager.eliminaFile(basePath + "pippo.txt");
        FileManager.scriviSuFile((basePath + "pippo.txt"), "ciao");

        Documento d1 = new Documento("s","s","s");
        d1.salvaSuFile(pathDaSerializzare);

        d1.caricaDaFile(pathDaSerializzare);

        Downloader downloader1 = new Downloader(basePath + "Download1.txt/");
        downloader1.setName("PrimoDownload");
        Downloader downloader2 = new Downloader(basePath + "Download2.txt/");
        downloader1.setName("SecondoDownload");
        Downloader downloader3 = new Downloader(basePath + "Download3.txt/");
        downloader1.setName("TerzoDownload");

        downloader1.start();
        Thread.sleep(2000);
        downloader2.start();
        Thread.sleep(5000);
        downloader3.start();
         */

        Scanner scanner = new Scanner(System.in);

        boolean esegui = true;
        while (esegui) {
            System.out.println("MENU\n" +
                    "1) Inserisci un nuovo documento.\n" +
                    "2) Cerca documento per titolo.\n" +
                    "3) Elimina un documento\n" +
                    "4) Stampa l'elenco dei documenti salvati.\n" +
                    "5) Esci.");


            System.out.println("Scegli l'azione da svolgere tramite il suo numero di riferimento: ");
            int azione = 0;
            while(azione <=0 || azione>5){
                try {
                    azione = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Errore: il valore inserito deve essere un numero compreso tra 1 e 5");
                }
                if (azione <=0 || azione>5){
                    System.out.println("Errore: il valore inserito deve essere un numero compreso tra 1 e 5. Riprova: ");
                }

            }

            switch (azione) {
                case 1:
                    System.out.println("inserisci il titolo del documento: ");
                    String titolo = scanner.nextLine();
                    System.out.println("inserisci l'autore del documento: ");
                    String autore = scanner.nextLine();
                    System.out.println("inserisci il contenuto del documento: ");
                    String contenuto = scanner.nextLine();
                    Documento documento = new Documento(titolo, autore, contenuto);
                    documento.salvaSuFile(basePath + titolo);


                    break;
                case 2:
                    System.out.println("inserisci il nome del file da cercare con annessa estensione: ");
                    String fileDaCercare = scanner.nextLine();
                    String PathDaCercare = basePath + fileDaCercare;
                    File file = new File(PathDaCercare);
                    if (!file.exists()) {
                        System.out.println("Il file non esiste");
                        break;
                    }

                    System.out.println("File trovato.");
                    Documento d = Documento.caricaDaFile(PathDaCercare);
                    if (d != null)
                        d.stampaInfo();
                    break;

                case 3:
                    System.out.println("inserisci il nome del file da eliminare con annessa estensione: ");
                    String fileDaEliminare = scanner.nextLine();
                    FileManager.eliminaFile(basePath + fileDaEliminare);
                    break;


                case 4:
                    File cartella = new File(basePath);
                    File[] files = cartella.listFiles();

                    if (files == null || files.length == 0) {
                        System.out.println("Non ci sono files.");
                        break;
                    }

                    System.out.println("Elenco documenti: ");
                    for (File f : files) {
                        Documento doc = Documento.caricaDaFile(f.getPath());
                        if (doc != null) {
                            System.out.print("- ");
                            doc.stampaInfo();
                        }
                    }
                    break;


                case 5:
                    esegui = false;
                    break;
            }
        }



    }
}