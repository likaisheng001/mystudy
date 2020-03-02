package com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.proxy;/**
 * Created by My on 2020-03-02.
 */

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:22:35 2020-03-02
 * @Modified By:
 */
public class GPProxy {
    public static final String ln = "\r\n";
    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h){
        try {
            //1. 动态生产源码 .java文件
            String src = generateSrc(interfaces);
            //System.out.println(src);
            //2. Java文件输出到磁盘，保存为文件$Proxy0.java
            String filePath = GPProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            //3. 把 .java文件编译成$Proxy0.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4. 把生成的.class文件加载到JVM中
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);

            f.delete(); // 删除类文件
            //5. 返回新的代理对象
            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.proxy;" + ln);
        sb.append("import com.panda.study.designmodel_gp.proxy.dynamicproxy.jdkproxy.IPerson;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);

        sb.append("public final class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("GPInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GPInvocationHandler h){" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}"+ln);

        for (Method m : interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();
            StringBuilder paramNames = new StringBuilder();
            StringBuilder paramValues = new StringBuilder();
            StringBuilder paramClasses = new StringBuilder();

            for (int i = 0; i < params.length; i++) {

            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
                sb.append("try{" + ln);
                    sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
                    sb.append("this.h.invoke(this, m, new Object[]{});" + ln);
                    sb.append("return;");
                sb.append("}" + ln );
                sb.append(       "    catch(Error _ex) { } " + ln );
                sb.append(       "    catch(Throwable throwable) " + ln );
                sb.append(       "    { " + ln );
                sb.append(       "        throw new UndeclaredThrowableException(throwable);" + ln );
                sb.append(       "    }" + ln );
            sb.append("}" + ln);
        }
        sb.append("}" + ln);
        return sb.toString();
    }
}
