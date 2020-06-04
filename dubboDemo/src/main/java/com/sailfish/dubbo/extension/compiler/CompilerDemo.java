package com.sailfish.dubbo.extension.compiler;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.compiler
 * @Description:
 * @date 2020/5/31 1:00 下午
 */
public class CompilerDemo {

    public static void main(String[] args) {
        final ClassPool classPool = ClassPool.getDefault();
        final CtClass ctClass = classPool.makeClass("Hello World");

    }
}
