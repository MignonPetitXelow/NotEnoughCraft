package src.nec.Tools;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceLocation
{
    public ResourceLocation(String s)
    {
        Path currentRelativePath = Paths.get("");
        String c = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
        this.s = c+"/"+s;
    }

    public String getResourcePath()
    {
        return s;
    }

    public String toString()
    {
        return s;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ResourceLocation)
        {
            return s.equals(((ResourceLocation)obj).s);
        }
        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return s.hashCode();
    }

    public Image getImage()
    {
       try {
           return Toolkit.getDefaultToolkit().getImage(s);
       } catch (Exception e) {
           System.err.println("Error loading image: "+s);
           return null;
       }
    }

    private String s;
}
