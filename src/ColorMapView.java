import javax.swing.*;
import java.awt.*;

class ColorMapView {

    private int mapWidth;
    private int mapHeight;

    ColorMapView() {
        JFrame frame = new JFrame("Color Map");

        frame.setSize(new Dimension(mapWidth, mapHeight));
        frame.setVisible(true);
    }
}