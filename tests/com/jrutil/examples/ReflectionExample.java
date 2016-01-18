package com.jrutil.examples;

import com.jrutil.reflect.ClassFinder;
import com.jrutil.reflect.ReflectedClass;
import com.jrutil.reflect.ReflectedMethod;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        ReflectedClass<?> clazz = ClassFinder.getClass(DummyClass.class.getName());
        ReflectedMethod method = clazz.getMethodByBytecodeSignature("public print(Ljava/lang/String;)V");
        clazz.getMethodByArgumentTypes(ClassFinder.getClass(String.class)); // Also works.
        System.out.println(clazz.toBytecodeSignatureString());
        System.out.println(method.toBytecodeSignatureString());
        method.invoke(new DummyClass(), "Hello");
    }

}
