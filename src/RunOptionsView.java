import org.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates the view containing the start and stop buttons.
 *
 * @author Lauren Rose
 * @version 26 December 2018
 */
class RunOptionsView {

    private KeyLogger logger;

    //private JButton start;
    private JButton showMap;
    private JLabel loggerStatus;

    RunOptionsView() {
        logger = new KeyLogger();

        JFrame frame = new JFrame("KeyColors");
        JPanel optionsButtonsPanel = new JPanel();

        JButton start = new JButton("Start logger");
        loggerStatus = new JLabel("Status: stopped");
        showMap = new JButton("Show map");
        showMap.setEnabled(false);

        start.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        showMap.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");

        start.addActionListener(e -> startClicked());
        showMap.addActionListener(e -> showMapClicked());

        optionsButtonsPanel.add(start);
        optionsButtonsPanel.add(showMap);
        optionsButtonsPanel.add(loggerStatus);

        frame.add(optionsButtonsPanel);
        frame.setSize(new Dimension(300, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void startClicked() {
        try {
            logger.startLogger();
            loggerStatus.setText("Status: running");
        } catch (NativeHookException e) {
            System.out.println("Error with NativeHook.");
        }
        showMap.setEnabled(true);
    }

    private void showMapClicked() {
        logger.stopLogger();
        loggerStatus.setText("Status: stopped");
    }
}
