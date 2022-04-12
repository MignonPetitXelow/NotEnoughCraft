package src.nec.Interface;

import src.nec.Items.item;

import java.util.List;

public class SearchBarItems
{


    List<item> itemsfound;
    public void newReasearch(String s)
    {
        Test.scrollPane.removeAll();
        for(int i =0; i < item.items.size(); i++)
        {
            if(item.items.get(i).getItem().contains(s))
            {
                itemsfound.add(item.items.get(i));
            }
        }
    }
}
