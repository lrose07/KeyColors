import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class KeyPressWriter {

//    private BufferedWriter writer;
    private File file = new File("keyPresses.txt");

    private static Logger lggr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    KeyPressWriter() {

    }

    void writeKeyPress(String keyPressed, boolean newMap) {
        file = new File("keyPresses.txt");
        if (newMap) {
            deleteFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(keyPressed);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            lggr.log(Level.INFO, "Error while writing to file.");
        }
    }


    void deleteFile() {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}