package com.jrutil.examples;

import com.jrutil.reflect.ClassFinder;
import com.jrutil.reflect.ReflectedClass;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException {
        ReflectedClass<?> clazz = ClassFinder.getClass(DummyClass.class.getName());
        System.out.println(clazz.toBytecodeSignatureString());
        System.out.println(clazz.getAllMethods()[0].toBytecodeSignatureString());
    }

}
