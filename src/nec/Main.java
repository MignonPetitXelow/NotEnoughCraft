package src.nec;

import src.nec.Event.KeyInput;
import src.nec.Event.NgIsOpen;
import src.nec.Interface.Test;
import src.nec.Items.items;


public class Main implements Runnable {
    public static void main(String[] args) {
        new items();
        new Main().run();
    }

    @Override
    public void run() {
        new Thread((Runnable) new Test()).start();
        new NgIsOpen();
        KeyInput.main(null);
    }


}