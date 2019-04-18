import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates the color tile view, based on the key
 * stroke data that is provided in a text file from the
 * key logger.
 *
 * @author Lauren Rose
 * @version 26 December 2018
 */
class ColorMapView {

    private int mapWidth;
    private int mapHeight;
    private int gridRows;
    private int gridColumns;

    private Color[] colors;
    private ArrayList<String> presses;

    ColorMapView() {
        JFrame frame = new JFrame("Color Map");

        processKeyPresses();

        JPanel mapPanel = new JPanel(new GridLayout(gridRows, gridColumns));

        for (Color color : colors) {
            mapPanel.add(new ColorTile(color));
        }

        frame.add(mapPanel);
        frame.setSize(new Dimension(mapWidth, mapHeight));
        frame.setVisible(true);
    }

    private class ColorTile extends JPanel {
        ColorTile(Color color) {
            this.setBackground(color);
        }
    }

    private void processKeyPresses() {
        readFile();
        getSizes(presses.size());
        assignColors();
    }

    private void getSizes(int dataSetSize) {
        // check is number prime
        // find the closest square
        // move outwards from there to find best dimensions
        // maybe start at a particular aspect ratio first?
        mapWidth = 500;
        mapHeight = 500;
        gridRows = (int) Math.sqrt((double) dataSetSize);
        gridColumns = (int) Math.sqrt((double) dataSetSize);
    }

    private void readFile() {
        presses = new ArrayList<>();
        File file = new File("keyPresses.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                presses.add(sc.next());
            }
            file.delete();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private void assignColors() {
        colors = new Color[presses.size()];
        // write data set for colors
        int locationInData = 0;
        for (String entry : presses) {
            switch (entry.toLowerCase()) {

                // NUMBER ROW
                case "`":
                    colors[locationInData] = COLOR_BACKTICK_KEY;
                    break;
                case "1":
                    colors[locationInData] = COLOR_1_KEY;
                    break;
                case "2":
                    colors[locationInData] = COLOR_2_KEY;
                    break;
                case "3":
                    colors[locationInData] = COLOR_3_KEY;
                    break;
                case "4":
                    colors[locationInData] = COLOR_4_KEY;
                    break;
                case "5":
                    colors[locationInData] = COLOR_5_KEY;
                    break;
                case "6":
                    colors[locationInData] = COLOR_6_KEY;
                    break;
                case "7":
                    colors[locationInData] = COLOR_7_KEY;
                    break;
                case "8":
                    colors[locationInData] = COLOR_8_KEY;
                    break;
                case "9":
                    colors[locationInData] = COLOR_9_KEY;
                    break;
                case "0":
                    colors[locationInData] = COLOR_0_KEY;
                    break;
                case "-":
                    colors[locationInData] = COLOR_DASH_KEY;
                    break;
                case "=":
                    colors[locationInData] = COLOR_EQUAL_KEY;
                    break;
                case "⌫":
                    colors[locationInData] = COLOR_DELETE_KEY;
                    break;

                // TAB ROW
                case "⇥":
                    colors[locationInData] = COLOR_TAB_KEY;
                    break;
                case "q":
                    colors[locationInData] = COLOR_Q_KEY;
                    break;
                case "w":
                    colors[locationInData] = COLOR_W_KEY;
                    break;
                case "e":
                    colors[locationInData] = COLOR_E_KEY;
                    break;
                case "r":
                    colors[locationInData] = COLOR_R_KEY;
                    break;
                case "t":
                    colors[locationInData] = COLOR_T_KEY;
                    break;
                case "y":
                    colors[locationInData] = COLOR_Y_KEY;
                    break;
                case "u":
                    colors[locationInData] = COLOR_U_KEY;
                    break;
                case "i":
                    colors[locationInData] = COLOR_I_KEY;
                    break;
                case "o":
                    colors[locationInData] = COLOR_O_KEY;
                    break;
                case "p":
                    colors[locationInData] = COLOR_P_KEY;
                    break;
                case "[":
                    colors[locationInData] = COLOR_LEFT_BRACKET_KEY;
                    break;
                case "]":
                    colors[locationInData] = COLOR_RIGHT_BRACKET_KEY;
                    break;
                case "\\":
                    colors[locationInData] = COLOR_BACKSLASH_KEY;
                    break;

                // CAPS LOCK ROW
                case "a":
                    colors[locationInData] = COLOR_A_KEY;
                    break;
                case "s":
                    colors[locationInData] = COLOR_S_KEY;
                    break;
                case "d":
                    colors[locationInData] = COLOR_D_KEY;
                    break;
                case "f":
                    colors[locationInData] = COLOR_F_KEY;
                    break;
                case "g":
                    colors[locationInData] = COLOR_G_KEY;
                    break;
                case "h":
                    colors[locationInData] = COLOR_H_KEY;
                    break;
                case "j":
                    colors[locationInData] = COLOR_J_KEY;
                    break;
                case "k":
                    colors[locationInData] = COLOR_K_KEY;
                    break;
                case "l":
                    colors[locationInData] = COLOR_L_KEY;
                    break;
                case ";":
                    colors[locationInData] = COLOR_COLON_KEY;
                    break;
                case "'":
                    colors[locationInData] = COLOR_QUOTATION_KEY;
                    break;
                case "⏎":
                    colors[locationInData] = COLOR_ENTER_KEY;
                    break;

                // shift row
                case "⇧":
                    colors[locationInData] = COLOR_SHIFT_KEY;
                    break;
                case "z":
                    colors[locationInData] = COLOR_Z_KEY;
                    break;
                case "x":
                    colors[locationInData] = COLOR_X_KEY;
                    break;
                case "c":
                    colors[locationInData] = COLOR_C_KEY;
                    break;
                case "v":
                    colors[locationInData] = COLOR_V_KEY;
                    break;
                case "b":
                    colors[locationInData] = COLOR_B_KEY;
                    break;
                case "n":
                    colors[locationInData] = COLOR_N_KEY;
                    break;
                case "m":
                    colors[locationInData] = COLOR_M_KEY;
                    break;
                case ",":
                    colors[locationInData] = COLOR_COMMA_KEY;
                    break;
                case ".":
                    colors[locationInData] = COLOR_PERIOD_KEY;
                    break;
                case "/":
                    colors[locationInData] = COLOR_FRONT_SLASH_KEY;
                    break;

                // space row
                case "⌃":
                    colors[locationInData] = COLOR_CONTROL_KEY;
                    break;
                case "⌥":
                    colors[locationInData] = COLOR_ALT_KEY;
                    break;
                case "⌘":
                    colors[locationInData] = COLOR_APPLE_KEY;
                    break;
                case "␣":
                    colors[locationInData] = COLOR_SPACE_KEY;
                    break;
                case "←":
                    colors[locationInData] = COLOR_LEFT_KEY;
                    break;
                case "↓":
                    colors[locationInData] = COLOR_DOWN_KEY;
                    break;
                case "↑":
                    colors[locationInData] = COLOR_UP_KEY;
                    break;
                case "→":
                    colors[locationInData] = COLOR_RIGHT_KEY;
                    break;

                default:
                    colors[locationInData] = Color.GRAY;
            }
            locationInData++;
        }
    }

    // number row
    private final Color COLOR_BACKTICK_KEY = new Color(255, 232, 232);
    private final Color COLOR_1_KEY = new Color(249, 204, 212);
    private final Color COLOR_2_KEY = new Color(249, 189, 192);
    private final Color COLOR_3_KEY = new Color(249, 146, 148);
    private final Color COLOR_4_KEY = new Color(249, 97, 109);
    private final Color COLOR_5_KEY = new Color(255, 74, 74);
    private final Color COLOR_6_KEY = new Color(249, 60, 57);
    private final Color COLOR_7_KEY = new Color(249, 45, 64);
    private final Color COLOR_8_KEY = new Color(249, 31, 41);
    private final Color COLOR_9_KEY = new Color(249, 17, 27);
    private final Color COLOR_0_KEY = new Color(197, 2, 13);
    private final Color COLOR_DASH_KEY = new Color(129, 2, 8);
    private final Color COLOR_EQUAL_KEY = new Color(90, 1, 6);
    private final Color COLOR_DELETE_KEY = new Color(50, 1, 4);

    // tab row
    private final Color COLOR_TAB_KEY = new Color(231, 255, 238);
    private final Color COLOR_Q_KEY = new Color(225, 255, 233);
    private final Color COLOR_W_KEY = new Color(209, 255, 217);
    private final Color COLOR_E_KEY = new Color(192, 255, 201);
    private final Color COLOR_R_KEY = new Color(180, 255, 183);
    private final Color COLOR_T_KEY = new Color(170, 255, 173);
    private final Color COLOR_Y_KEY = new Color(146, 255, 148);
    private final Color COLOR_U_KEY = new Color(123, 255, 130);
    private final Color COLOR_I_KEY = new Color(77, 255, 86);
    private final Color COLOR_O_KEY = new Color(42, 255, 57);
    private final Color COLOR_P_KEY = new Color(12, 255, 18);
    private final Color COLOR_LEFT_BRACKET_KEY = new Color(9, 202, 14);
    private final Color COLOR_RIGHT_BRACKET_KEY = new Color(7, 166, 12);
    private final Color COLOR_BACKSLASH_KEY = new Color(5, 104, 7);

    // caps lock row
    private final Color COLOR_CAPS_LOCK_KEY = new Color(235, 238, 255);
    private final Color COLOR_A_KEY = new Color(220, 221, 255);
    private final Color COLOR_S_KEY = new Color(199, 198, 255);
    private final Color COLOR_D_KEY = new Color(170, 166, 255);
    private final Color COLOR_F_KEY = new Color(145, 140, 255);
    private final Color COLOR_G_KEY = new Color(118, 110, 255);
    private final Color COLOR_H_KEY = new Color(99, 90, 255);
    private final Color COLOR_J_KEY = new Color(78, 68, 255);
    private final Color COLOR_K_KEY = new Color(58, 45, 255);
    private final Color COLOR_L_KEY = new Color(40, 23, 255);
    private final Color COLOR_COLON_KEY = new Color(22, 3, 224);
    private final Color COLOR_QUOTATION_KEY = new Color(17, 2, 177);
    private final Color COLOR_ENTER_KEY = new Color(11, 1, 110);

    // shift row
    private final Color COLOR_SHIFT_KEY = new Color(255, 226, 251);
    private final Color COLOR_Z_KEY = new Color(254, 187, 255);
    private final Color COLOR_X_KEY = new Color(247, 156, 255);
    private final Color COLOR_C_KEY = new Color(247, 128, 255);
    private final Color COLOR_V_KEY = new Color(245, 92, 255);
    private final Color COLOR_B_KEY = new Color(241, 56, 255);
    private final Color COLOR_N_KEY = new Color(243, 26, 255);
    private final Color COLOR_M_KEY = new Color(226, 4, 233);
    private final Color COLOR_COMMA_KEY = new Color(185, 3, 191);
    private final Color COLOR_PERIOD_KEY = new Color(149, 2, 153);
    private final Color COLOR_FRONT_SLASH_KEY = new Color(102, 1, 105);

    // space row
    private final Color COLOR_CONTROL_KEY = new Color(255, 235, 232);
    private final Color COLOR_ALT_KEY = new Color(255, 229, 176);
    private final Color COLOR_APPLE_KEY = new Color(255, 228, 146);
    private final Color COLOR_SPACE_KEY = new Color(255, 221, 108);
    private final Color COLOR_LEFT_KEY = new Color(255, 215, 92);
    private final Color COLOR_DOWN_KEY = new Color(255, 196, 78);
    private final Color COLOR_UP_KEY = new Color(233, 158, 20);
    private final Color COLOR_RIGHT_KEY = new Color(199, 130, 6);
}