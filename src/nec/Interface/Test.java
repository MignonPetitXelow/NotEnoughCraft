package src.nec.Interface;

import src.nec.Items.ItemCanvas;
import src.nec.Items.item;
import src.nec.Items.items;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Test implements Runnable
{
    public static JFrame frame;
    public static JTextField searchBar;
    public static JScrollPane scrollPane;
    public static List<JButton> buttons;

    @Override
    public void run() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("Test");
        JPanel panel = new JPanel();

        System.out.println("Gui is running");

        frame.setType(Window.Type.UTILITY);
        frame.setSize((int) (screenSize.width/2.7), screenSize.height);
        frame.setPreferredSize(new Dimension((int) (screenSize.width/2.7), screenSize.height));

        frame.setUndecorated(true);

        frame.setBackground(new Color(0, 0, 0, 50));

        ItemsList(frame);
        searchBar(frame);

        frame.setAlwaysOnTop(true);
        frame.requestFocus();


        frame.pack();


        frame.setVisible(false);

        frame.setLocation(0, 0);

    }

    public void searchBar(JFrame frame)
    {
        searchBar = new JTextField();
        JPanel searchBarPanel = new JPanel();
        searchBarPanel.setLayout(null);
        searchBarPanel.setBackground(new Color(25, 25, 25, 0));

        searchBar.setBorder(null);
        searchBar.setBounds((int) ((int) (frame.getWidth()/1.5) /4)-5, 5, (int) (frame.getWidth()/1.2), (int) (frame.getHeight()/27));
        searchBar.setFont(new Font("Minecraft", Font.PLAIN, (int) (frame.getHeight()/50)));
        searchBar.setForeground(Color.WHITE);
        searchBar.setAlignmentY(JTextField.CENTER);
        searchBar.setBackground(new Color(25, 25, 25, 140));
        searchBarPanel.add(searchBar);
        frame.add(searchBarPanel);
    }

    public void ItemsList(JFrame frame)
    {
        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setLayout(null);
        scrollPane.setBounds(5, 50, frame.getWidth()-11, (int) (frame.getHeight()/1.05));
        scrollPane.setBackground(new Color(255, 255, 255, 0));

        for(int i = 0; i < item.items.size(); i++)
        {
            scrollPane.add(new ItemCanvas(item.items.get(i), i));
        }

       frame.add(scrollPane);
    }
}


