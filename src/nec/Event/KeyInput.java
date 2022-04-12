package src.nec.Event;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import src.nec.Interface.SearchBarItems;
import src.nec.Interface.Test;

public class KeyInput implements NativeKeyListener {
    public void nativeKeyPressed(NativeKeyEvent e) {

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        Test.frame.update(Test.frame.getGraphics());
        if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Escape")) {
            if(OpenNec.GuiOpen)
            {
                OpenNec.GuiOpen = false;
                Test.frame.setVisible(false);
                return;
            }
        }
        else if(NativeKeyEvent.getKeyText(e.getKeyCode()).equals("F12"))
        {
            if(!OpenNec.GuiOpen)
            {
                OpenNec.GuiOpen = true;
                Test.frame.setVisible(true);
                return;
            }
            if(OpenNec.GuiOpen)
            {
                OpenNec.GuiOpen = false;
                Test.frame.setVisible(false);
                return;
            }
        } else {
            if (Test.frame != null)
                SearchBarItems.newReasearch(Test.searchBar.getText());
        }
    }































    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyInput());
    }
}