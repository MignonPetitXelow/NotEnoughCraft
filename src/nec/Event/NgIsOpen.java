package src.nec.Event;

import src.nec.Interface.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NgIsOpen
{
    public static boolean isOpen = false;

    public NgIsOpen()
    {
        //Technique du bled
        new Thread(new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    String findProcess = "NationsGlory.exe";
                    String filenameFilter = "/nh /fi \"Imagename eq "+findProcess+"\"";
                    String tasksCmd = System.getenv("windir") +"/system32/tasklist.exe "+filenameFilter;

                    Process p = null;
                    try {
                        p = Runtime.getRuntime().exec(tasksCmd);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

                    ArrayList<String> procs = new ArrayList<String>();
                    String line = null;
                    while (true) {
                        try {
                            if (!((line = input.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        procs.add(line);
                    }

                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    isOpen = procs.stream().filter(row -> row.indexOf(findProcess) > -1).count() > 0;
                    System.out.println("NgIsOpen: "+isOpen);


                }
            }

        }).start();
    }
}
