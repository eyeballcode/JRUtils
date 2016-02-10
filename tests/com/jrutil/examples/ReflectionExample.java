package com.jrutil.examples;

import com.jrutil.reflect.ClassFinder;
import com.jrutil.reflect.ReflectedClass;
import com.jrutil.reflect.ReflectedMethod;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        ReflectedClass<?> clazz = ClassFinder.getClass(DummyClass.class);
        System.out.println(clazz.toBytecodeSignatureString());
        for (ReflectedMethod method : clazz.getAllMethods())
            System.out.println(method.toBytecodeSignatureString());
    }

}
