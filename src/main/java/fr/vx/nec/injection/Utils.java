package fr.vx.nec.injection;

import com.sun.tools.attach.VirtualMachine;
import org.apache.commons.io.IOUtils;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class Utils
{
    public static void attach(String a, File in)
    {
        System.setProperty("java.library.path", System.getProperty("java.home").replace("jre","jdk")+"\\jre\\bin");

        try
        {
            Field field = ClassLoader.class.getDeclaredField("sys_paths");
            field.setAccessible(true);
            field.set(null, null);
        }
        catch(Exception e){e.printStackTrace();return;}
        File agent = new File(System.getProperty("user.home")+"/Desktop", "agent.jar");
        buildAgent(in, agent);

        try
        {
            VirtualMachine vm = VirtualMachine.attach(a);

            vm.loadAgent(agent.getAbsolutePath());
            vm.detach();
            System.out.println("Detached");
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void buildAgent(File in, File out)
    {
        try
        {
            JarFile jar = new JarFile(in);
            Manifest manifest = new Manifest(jar.getManifest());
            manifest.getMainAttributes().putValue("Agent-Class", Agent.class.getName());
            manifest.getMainAttributes().putValue("Can-Retransform-Classes", "true");
            manifest.getMainAttributes().putValue("Can-Redefine-Classes", "true");
            manifest.getMainAttributes().putValue("Can-Set-Native-Prefix", "true");

            JarOutputStream jarOut = new JarOutputStream(new FileOutputStream(out), manifest);

            Enumeration<JarEntry> entries = jar.entries();
            while(entries.hasMoreElements())
            {
                JarEntry entry = entries.nextElement();
                if(!entry.getName().equals("META-INF/MANIFEST.MF"))
                {
                    jarOut.putNextEntry(entry);
                    if(!entry.isDirectory())
                    {
                        jarOut.write(IOUtils.toByteArray(jar.getInputStream(entry)));
                    }
                }
            }
            jar.close();
            jarOut.close();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static ArrayList<String> getProcesses()
    {
        ArrayList<String> processes = new ArrayList<String>();

        try
        {
            MonitoredHost monitoredHost = MonitoredHost.getMonitoredHost("localhost");
            for(int id : monitoredHost.activeVms())
            {
                MonitoredVm monitoredVm = monitoredHost.getMonitoredVm(new VmIdentifier("//"+id));

                String mainClass = MonitoredVmUtil.mainClass(monitoredVm, true);
                String userInfo = monitoredVm.getVmIdentifier().getUserInfo();

                if(!mainClass.isEmpty())
                {
                    processes.add(id+":"+mainClass);
                }
            }
        }
        catch(Exception e){e.printStackTrace();}

        return processes;
    }
}
