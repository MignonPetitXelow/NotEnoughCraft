package src.fr.vx.notenoughcraft.nationglory;


import src.fr.vx.notenoughcraft.Item.Items;
import src.fr.vx.notenoughcraft.Item.item;
import src.fr.vx.notenoughcraft.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GalacticrafItem extends JButton implements MouseListener {

    public static List<GalacticrafItem> items = new ArrayList<GalacticrafItem>();

    private URL url;
    private final String name;
    private Image image;
    private JLabel label;

    public GalacticrafItem(item item, Box box) {

        this.name = item.getName();

        try {

            this.url = new URL(item.getTextureUrl());
            this.image = ImageIO.read(this.url).getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING);
            this.label = new JLabel(new ImageIcon(this.image));
            this.label.setLayout(new FlowLayout());
            this.label.setBounds(15 - 20 ,this.getHeight()/2 - 10, 80, 80);
            this.label.setLocation(0,0);
            this.label.setText(this.name);
            this.label.setForeground(Color.white);
            this.label.setFont(new Font("Minecraft", Font.PLAIN, 25));
            this.add(label);

        } catch (Exception error) {

            error.printStackTrace();

        }

        this.setForeground(Color.white);
        this.setBorder(null);
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFocusable(false);
        this.setBackground(new Color(0,0,0,100));
        this.setPreferredSize(new Dimension(Main.frame.getWidth(), 90));
        this.setMaximumSize(new Dimension((int) (Main.frame.getWidth()/1.05), 90));
        this.setBounds(0,0, box.getWidth(), 80);
        this.addMouseListener(this);
        this.setUI(new MetalButtonUI() { protected void paintButtonPressed(Graphics g, AbstractButton b) {


        }});

    }

    @Override
    public void mouseExited(MouseEvent e) {
        //on move mouse off the button
        this.setBackground(new Color(0,0,0,100));
        Main.frame.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(new Color(0,0,0,100));
        Main.frame.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        this.setBackground(new Color(0,0,0,150));
        Main.frame.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //on button hover
        this.setBackground(new Color(0,0,0,150));
        Main.frame.repaint();
    }

    public static void register(Box box) {

        items.add(new GalacticrafItem(Items.iron_ingot, box));

        box.add(Box.createHorizontalStrut(15));

        for (int i = 0; i < items.size(); ++i) {

            items.get(i).setBounds(0, 90 * i, Main.frame.getWidth(), 80);
            box.add(items.get(i));
            box.add(Box.createVerticalStrut(10));

        }

    }

}
