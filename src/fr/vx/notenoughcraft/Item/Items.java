package src.fr.vx.notenoughcraft.Item;

import src.fr.vx.notenoughcraft.Item.Recipes.COMPRESSOR;

import java.util.Arrays;

public class Items
{
    public static item air;
    public static item iron_ingot;
    public static item compressed_iron;

    public static void register()
    {
        air = new item("air", "https://static.wikia.nocookie.net/minecraft_gamepedia/images/d/d2/Blank.png",null);
        iron_ingot = new item("iron_ingot", "https://static.wikia.nocookie.net/minecraft_gamepedia/images/f/fc/Iron_Ingot_JE3_BE2.png",null);
        compressed_iron = new item("compressed_iron", "", new Recipe(new COMPRESSOR(Arrays.asList(iron_ingot, air), compressed_iron)));
    }
}
