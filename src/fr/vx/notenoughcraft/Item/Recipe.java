package src.fr.vx.notenoughcraft.Item;

import src.fr.vx.notenoughcraft.Item.Recipes.COMPRESSOR;
import src.fr.vx.notenoughcraft.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Recipe
{
    private static JFrame frame;

    public Recipe(COMPRESSOR compressor)
    {
        item result = compressor.getResult();
        List<item> ingredients = compressor.getItems();

        frame = new JFrame("Recipe");
        frame.setBackground(new Color(0,0,0,100));
        frame.setBounds(Main.frame.getWidth()/2-300,Main.frame.getHeight()/2-300,300,300);

        JPanel craft = new JPanel();
        craft.setLayout(new GridLayout(3,3));
        craft.setBackground(new Color(0,0,0,150));

        for(int i = 0; i < 9; ++i)
        {
            try {
                URL url = new URL(compressor.getItems().get(i).getTextureUrl());
                Image image = ImageIO.read(url);
                craft.add(new JLabel(new ImageIcon(image)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        frame.add(craft);
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public class closeButton extends JButton implements MouseListener {
        public closeButton(int x, int y)
        {
            this.setBackground(new Color(0, 0, 0, 0));
            this.setText("X");
            this.setBounds(x, y, 20, 20);
            this.setBorder(null);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            frame.dispose();
            try {
                Main.main(null);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (FontFormatException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
