import org.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.*;

class RunOptionsView {

    private KeyLogger logger;

    RunOptionsView() {
        logger = new KeyLogger();

        JFrame frame = new JFrame("KeyColors");
        JPanel optionsButtonsPanel = new JPanel();

        JButton start = new JButton("Start logger");
        JButton stop = new JButton("Stop logger");

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
