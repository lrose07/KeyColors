import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


/**
 * This class uses JNativeHook to create and launch a key logger that
 * runs in the background on the machine. When the "Stop" button is
 * pressed, a colorful tile map of key presses is displayed to
 * the user.
 *
 * @author Lauren Rose
 * @version 26 December 2018
 */
public class KeyLogger implements NativeKeyListener {
    private KeyPressWriter kpWriter;

    /**
     * Creates a new KeyLogger object
     */
    KeyLogger() {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        kpWriter = new KeyPressWriter();
    }

    /**
     * Saves pressed keys to log file
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        System.out.println(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()) + " pressed");
        kpWriter.writeKeyPress(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }

    void stopLogger() {
        createColorMap();
        //System.exit(0);
    }

    void startLogger() throws NativeHookException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

    private void createColorMap() {
        new ColorMapView();
    }

    /**
     * For handling the released keys. Not needed in this implementation.
     */
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) { }

    /**
     * For handling the typed keys. Not needed in this implementation.
     */
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) { }
}