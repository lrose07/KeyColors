import java.io.*;

class KeyPressWriter {

    private BufferedWriter writer;
    private boolean newSession;

    KeyPressWriter() {
        newSession = true;
    }

    void writeKeyPress(String keyPressed) {
        File file = new File("keyPresses.txt");
        if (file.exists() && file.isFile() && newSession)
        {
            boolean isDeleted = file.delete();
            if (!isDeleted) {
                System.out.println("File was not deleted");
            }
            newSession = false;
        }
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(keyPressed);
            writer.newLine();
            writer.flush();
            //System.out.println(writer.toString());
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
}