/**
 * This class launches the options view, which contains
 * the buttons needed to execute the program.
 *
 * @author Lauren Rose
 * @version 26 December 2018
 */
public class Driver {
    /**
     * The main method.
     * @param args - Command-line arguments
     */
    public static void main(String args[]) {
        new RunOptionsView();
    }
}

/*
TODO: Add user options to control various aspects (color palette, dimensions, time or stroke count to capture, etc)
TODO: Refactor default colors (giant switch statement = messy)
TODO: Add security features for text file
TODO: Algorithm for default dimensions
 */