
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;

class KeyPressWriter {

    private static Logger lggr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    KeyPressWriter() {

    }

    void writeKeyPress(String keyPressed, boolean newMap) {
        File file = new File("keyPresses.txt");
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
        try {
            Files.deleteIfExists(FileSystems.getDefault().getPath("keyPresses.txt"));
        } catch (IOException e) {
            lggr.log(Level.INFO, "File not found");
        }

    }
}