import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
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

    private HashMap<String, Color> colorAssignments;

    ColorMapView() {
        JFrame frame = new JFrame("Color Map");

        buildColorMap();
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
            if (entry.contains("Unknown")) {
                colors[locationInData] = Color.GRAY;
            } else {
                colors[locationInData] = colorAssignments.get(entry);
            }

            locationInData++;
        }
    }

    private void buildColorMap() {
        colorAssignments = new HashMap<>();

        buildNumberRow();
        buildTabRow();
        buildCapsLockRow();
        buildShiftRow();
        buildSpaceRow();
    }

    private void buildNumberRow() {
        colorAssignments.put("`", new Color(255, 232, 232));
        colorAssignments.put("1", new Color(249, 204, 212));
        colorAssignments.put("2", new Color(249, 189, 192));
        colorAssignments.put("3", new Color(249, 146, 148));
        colorAssignments.put("4", new Color(249, 97, 109));

        colorAssignments.put("5", new Color(255, 74, 74));
        colorAssignments.put("6", new Color(249, 60, 57));
        colorAssignments.put("7", new Color(249, 45, 64));
        colorAssignments.put("8", new Color(249, 31, 41));
        colorAssignments.put("9", new Color(249, 17, 27));
        colorAssignments.put("0", new Color(197, 2, 13));

        colorAssignments.put("-", new Color(129, 2, 8));
        colorAssignments.put("=", new Color(90, 1, 6));
        colorAssignments.put("⌫", new Color(50, 1, 4));
    }

    private void buildTabRow() {
        colorAssignments.put("⇥", new Color(231, 255, 238));

        colorAssignments.put("Q", new Color(225, 255, 233));
        colorAssignments.put("W", new Color(209, 255, 217));
        colorAssignments.put("E", new Color(192, 255, 201));
        colorAssignments.put("R", new Color(180, 255, 183));
        colorAssignments.put("T", new Color(170, 255, 173));

        colorAssignments.put("Y", new Color(146, 255, 148));
        colorAssignments.put("U", new Color(123, 255, 130));
        colorAssignments.put("I", new Color(77, 255, 86));
        colorAssignments.put("O", new Color(42, 255, 57));
        colorAssignments.put("P", new Color(12, 255, 18));

        colorAssignments.put("[", new Color(9, 202, 14));
        colorAssignments.put("]", new Color(7, 166, 12));
        colorAssignments.put("\\", new Color(5, 104, 7));
    }

    private void buildCapsLockRow() {
        colorAssignments.put("A", new Color(220, 221, 255));
        colorAssignments.put("S", new Color(199, 198, 255));
        colorAssignments.put("D", new Color(170, 166, 255));
        colorAssignments.put("F", new Color(145, 140, 255));

        colorAssignments.put("G", new Color(118, 110, 255));
        colorAssignments.put("H", new Color(99, 90, 255));
        colorAssignments.put("J", new Color(78, 68, 255));
        colorAssignments.put("K", new Color(58, 45, 255));
        colorAssignments.put("L", new Color(40, 23, 255));

        colorAssignments.put(";", new Color(22, 3, 224));
        colorAssignments.put("'", new Color(17, 2, 177));
        colorAssignments.put("⏎", new Color(11, 1, 110));

    }

    private void buildShiftRow() {
        colorAssignments.put("⇧", new Color(255, 226, 251));
        colorAssignments.put("Z", new Color(254, 187, 255));
        colorAssignments.put("X", new Color(247, 156, 255));
        colorAssignments.put("C", new Color(247, 128, 255));

        colorAssignments.put("V", new Color(245, 92, 255));
        colorAssignments.put("B", new Color(241, 56, 255));
        colorAssignments.put("N", new Color(243, 26, 255));
        colorAssignments.put("M", new Color(226, 4, 233));

        colorAssignments.put(",", new Color(185, 3, 191));
        colorAssignments.put(".", new Color(149, 2, 153));
        colorAssignments.put("/", new Color(102, 1, 105));
    }

    private void buildSpaceRow() {
        colorAssignments.put("⌃", new Color(255, 235, 232));
        colorAssignments.put("⌥", new Color(255, 229, 176));
        colorAssignments.put("⌘", new Color(255, 228, 146));
        colorAssignments.put("␣", new Color(255, 221, 108));

        colorAssignments.put("←", new Color(255, 215, 92));
        colorAssignments.put("↓", new Color(255, 196, 78));
        colorAssignments.put("↑", new Color(233, 158, 20));
        colorAssignments.put("→", new Color(199, 130, 6));
    }
}