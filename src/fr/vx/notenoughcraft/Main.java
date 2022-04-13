package src.fr.vx.notenoughcraft;

import src.fr.vx.notenoughcraft.Item.Items;
import src.fr.vx.notenoughcraft.nationglory.GalacticrafItem;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static JFrame frame;

    public static void main(String[] args) throws IOException, FontFormatException {
        Items.register();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Minecraft.ttf")));
        frame = new JFrame("NG-Craft");
        frame.setSize((int) (screenSize.width/2.7), screenSize.height);
        frame.setPreferredSize(new Dimension((int) (screenSize.width/2.7), screenSize.height));
        Box box = Box.createVerticalBox();
        box.setSize(frame.getWidth() - 11, (int) (frame.getHeight()/1.05));
        box.setBounds(5, 50, frame.getWidth() - 11, (int) (frame.getHeight()/1.05));
        GalacticrafItem.register(box);
        JScrollPane scrollPane = new JScrollPane(box);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.setBounds(5, 50, frame.getWidth() - 11, (int) (frame.getHeight()/1.05));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.setType(Window.Type.UTILITY);
        frame.setLocation(0, 0);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 50));
        frame.setAlwaysOnTop(true);
        frame.add(scrollPane);
        frame.pack();
        frame.setLocation(0, 0);
        frame.setVisible(true);

    }
}
