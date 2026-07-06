import java.io.FileWriter;
import java.io.IOException;

public class Downloader extends Thread {
    private static int numThread = 1;
    private final String pathFile;

    public Downloader(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void run() {

        System.out.println("Avvio del download numero di: " + pathFile);

        try (FileWriter fw = new FileWriter(pathFile)) {
            fw.write("Download completato.");
            System.out.println("Download del thread numero " + numThread + "completato");
            numThread++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
