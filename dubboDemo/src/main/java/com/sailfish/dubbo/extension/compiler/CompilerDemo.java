package com.sailfish.dubbo.extension.compiler;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.compiler
 * @Description:
 * @date 2020/5/31 1:00 下午
 */
public class CompilerDemo {

    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        final ClassPool classPool = ClassPool.getDefault();
        final CtClass ctClass = classPool.makeClass("Hello World");
        final CtMethod ctMethod = CtNewMethod.make("public static void test(){ System.out.println(\"Hello World\");}", ctClass);
        ctClass.addMethod(ctMethod);
        final Class aClass = ctClass.toClass();

        final Object object = aClass.newInstance();
        final Method m = aClass.getDeclaredMethod("test", null);
        m.invoke(object, null);

    }
}
