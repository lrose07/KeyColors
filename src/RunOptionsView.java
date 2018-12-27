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

    RunOptionsView() {
        logger = new KeyLogger();

        JFrame frame = new JFrame("KeyColors");
        JPanel optionsButtonsPanel = new JPanel();

        JButton start = new JButton("Start logger");
        JButton stop = new JButton("Stop logger");

        start.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        stop.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");

        start.addActionListener(e -> startClicked());
        stop.addActionListener(e -> stopClicked());

        optionsButtonsPanel.add(start);
        optionsButtonsPanel.add(stop);

        frame.add(optionsButtonsPanel);
        frame.setSize(new Dimension(300, 100));
        frame.setVisible(true);
    }

    private void startClicked() {
        try {
            logger.startLogger();
        } catch (NativeHookException e) {
            System.out.println("Error with NativeHook.");
        }
    }

    private void stopClicked() {
        logger.stopLogger();
    }
}
