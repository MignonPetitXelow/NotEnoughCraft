package fr.vx.nec.injection;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

import java.util.List;

@HookClass("net/minecraft/client/Minecraft")
public class MinecraftTransformer extends Injector {

    @Override
    public void inject(ClassReader classReader, ClassNode classNode) {
        for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
            if (methodNode.name.equals("func_71407_l") && methodNode.desc.equals("()V")) {
                InsnList insnList = new InsnList();
                insnList.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
                insnList.add(new LdcInsnNode("Test"));
                insnList.add((new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
                methodNode.instructions.insert(insnList);
            }
        }
    }
}
