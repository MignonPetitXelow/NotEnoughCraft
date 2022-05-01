package fr.vx.nec.injection;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Agent
{
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent loaded");
        inst.addTransformer(new MinecraftTransformer(), true);
        Arrays.stream(inst.getAllLoadedClasses()).forEach(aClass -> {
            if (inst.isModifiableClass(aClass) && !aClass.getName().contains(".")) {
                try {
                    inst.retransformClasses(aClass);
                } catch (UnmodifiableClassException e) {

                }
            }
        });
    }
}
