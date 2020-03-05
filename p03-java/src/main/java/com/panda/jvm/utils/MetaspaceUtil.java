package com.panda.jvm.utils;/**
 * Created by My on 2019-12-14.
 */

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:43:23 2019-12-14
 * @Modified By:
 */
public class MetaspaceUtil extends ClassLoader{
    public static List<Class<?>> createClasses(){
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (int i = 0; i < 10000000; ++i){
            ClassWriter cw = new ClassWriter(0);
            cw.visit(Opcodes.V1_1, Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
            MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC,"<init>","()V",null,null);
            mv.visitVarInsn(Opcodes.ALOAD,0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Object","<init>","()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1,1);
            mv.visitEnd();
            MetaspaceUtil test = new MetaspaceUtil();
            byte[] code = cw.toByteArray();
            Class<?> exampleClass = test.defineClass("Class"+i,code,0,code.length);
            classes.add(exampleClass);
        }
        return classes;
    }
}
