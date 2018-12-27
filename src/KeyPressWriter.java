import java.io.*;

class KeyPressWriter {

    private BufferedWriter writer;
    //private boolean newSession = true;

    KeyPressWriter() {
        //newSession = true;
        //System.out.println("New session in KeyLogger constructor: " + newSession);
    }

    void writeKeyPress(String keyPressed, boolean newMap) {
        File file = new File("keyPresses.txt");
        //System.out.println("New session: " + newMap);
        if (file.exists() && file.isFile() && newMap) {
            System.out.println("hit if statement");
            file.delete();
//            if (!isDeleted) {
//                System.out.println("File was not deleted");
//            }
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
}