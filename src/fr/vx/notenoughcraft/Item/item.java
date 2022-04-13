package src.fr.vx.notenoughcraft.Item;

public class item
{
    private String name;
    private String TextureUrl;
    private Recipe recipe;

    public item(String name, String TextureUrl, Recipe recipe)
    {
        this.name = name;
        this.TextureUrl = TextureUrl;
        this.recipe = recipe;
    }

    public String getName()
    {
        return name;
    }

    public String getTextureUrl()
    {
        return TextureUrl;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }
}
