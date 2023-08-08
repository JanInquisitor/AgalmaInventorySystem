package org.agalma;

import org.agalma.views.AgalmaSystemFrame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;


public class AgalmaSystem {
    public static void main(String[] args) {

        // Main Engine
        try {
            mainEngine();
        } catch (InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mainEngine() throws InterruptedException, InvocationTargetException {
        Runnable initFrame = new Runnable() {
            @Override
            public void run() {
                new AgalmaSystemFrame();
            }
        };

        SwingUtilities.invokeAndWait(initFrame);
    }
}