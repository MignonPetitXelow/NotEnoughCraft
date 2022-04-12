package src.nec.Items;


public class items
{
    public static item Test;
    public static item Compressor;
    public items()
    {
         Test = new item("Blue Solar Wafer", "1234","https://wiki.micdoodle8.com/images/b/bc/Grid_Blue_Solar_Wafer.png" );
         Compressor = new item("Compressor", "1234", "https://wiki.micdoodle8.com/images/7/74/Grid_Compressor.png");

         item.addItem(Test);
         item.addItem(Compressor);
    }
}
