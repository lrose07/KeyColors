import java.io.*;

class KeyPressWriter {

    private BufferedWriter writer;
    private File file = new File("keyPresses.txt");;

    KeyPressWriter() {

    }

    void writeKeyPress(String keyPressed, boolean newMap) {
        file = new File("keyPresses.txt");
        if (newMap) {
            deleteFile();
        }
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(keyPressed);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error while writing to file.");
        } finally {
            if (writer != null) try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Something strange has happened");
            }
        }
    }


    void deleteFile() {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}