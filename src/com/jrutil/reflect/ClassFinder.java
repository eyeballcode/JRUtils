package com.jrutil.reflect;

public class ClassFinder {

    public static ReflectedClass<?> getClass(String className) throws ClassNotFoundException {
        return new ReflectedClass<>(Class.forName(className));
    }

    public static ReflectedClass getClass(Class<?> baseClass) {
        return new ReflectedClass<>(baseClass);
    }
}
