package src.nec.Items;

import java.util.ArrayList;
import java.util.List;

public class item
{
    private String item;
    private String description;
    private String imageurl;

    public static List<item> items = new ArrayList<>();

    public item(String item, String description, String imageurl)
    {
        this.item = item;
        this.description = description;
        this.imageurl = imageurl;
    }

    public String getItem()
    {
        return item;
    }

    public String getDescription()
    {
        return description;
    }

    public String getImageurl()
    {
        return imageurl;
    }

    public static void addItem(item item)
    {
        items.add(item);
    }
}
