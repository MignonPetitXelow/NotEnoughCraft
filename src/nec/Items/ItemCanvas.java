package src.nec.Items;

import src.nec.Interface.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ItemCanvas extends JButton
{
    public ItemCanvas(item item, int ListPosition)
    {
        this.setBorder(null);
        int clean = 90 * ListPosition;
        this.setBounds(0,0+clean, Test.scrollPane.getWidth(), 80);
        JLabel label = new JLabel();
        try
        {
            URL url = new URL(item.getImageurl());
            Image image = ImageIO.read(url).getScaledInstance(80,80,Image.SCALE_AREA_AVERAGING);
            label = new JLabel(new ImageIcon(image));
            label.setLayout(new FlowLayout());
            label.setBounds((int) (15),this.getHeight()/2, 64, 64);
            label.setLocation(25,0);
            label.updateUI();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.add(label);

        this.setBackground(new Color(0,0,0,100));
    }

}
