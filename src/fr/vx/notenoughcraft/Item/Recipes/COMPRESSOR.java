package src.fr.vx.notenoughcraft.Item.Recipes;

import src.fr.vx.notenoughcraft.Item.item;

import java.util.List;

import static src.fr.vx.notenoughcraft.Item.Items.air;

public class COMPRESSOR
{
    private List<item> items;
    private item result;

    public COMPRESSOR(List<item> l, item result)
    {
        for (int i = 0; i < 9-l.size(); ++i)
        {
            l.add(i,air);
        }

        this.items = l;
        this.result = result;
    }

    public item getResult()
    {
        return result;
    }

    public List<item> getItems() {
        return items;
    }
}
