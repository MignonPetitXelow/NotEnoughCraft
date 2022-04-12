package src.nec.Interface;

import src.nec.Items.ItemCanvas;
import src.nec.Items.item;

import java.util.ArrayList;
import java.util.List;

public class SearchBarItems
{

    public static void newReasearch(String s)
    {
        Test.scrollPane.removeAll();
        for(int i =0; i < item.items.size(); i++)
        {
            if(item.items.get(i).getItem().contains(s) || s.isBlank())
            {
                Test.scrollPane.add(new ItemCanvas(item.items.get(i), i));
            }
        }
        Test.scrollPane.updateUI();
    }
}
