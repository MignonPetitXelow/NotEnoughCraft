package fr.vx.nec.injection;

import java.io.File;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        System.loadLibrary("attach");
        Utils.getProcesses().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        String pid = scanner.nextLine();

        File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        Utils.attach(pid, file);

    }
}