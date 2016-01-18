package com.jrutil.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;


/**
 * A wrapper for {@link Class}
 *
 * @param <T> The class type.
 * @see Class
 */
public class ReflectedClass<T> {

    private final Class<T> underlyingClass;

    protected ReflectedClass(Class<T> clazz) {
        underlyingClass = clazz;
    }

    public ReflectedMethod[] getAllMethods() {
        Method[] methods = underlyingClass.getMethods();
        ReflectedMethod[] methods1 = new ReflectedMethod[methods.length];
        for (int i = 0; i < methods.length; i++)
            methods1[i] = new ReflectedMethod(methods[i]);
        return methods1;
    }


    /**
     * Returns a string representation of the class, in human readable code form.
     *
     * @return The string representation of the class.
     */
    @Override
    public String toString() {
        return underlyingClass.toString();
    }

    /**
     * Returns a string representation of the class, in bytecode signature form.
     *
     * @return The string representation of the class.
     */
    public String toBytecodeSignatureString() {
        StringBuilder out = new StringBuilder();
        int modifiers = underlyingClass.getModifiers();
        if (Modifier.isPublic(modifiers))
            out.append("public ");
        if (Modifier.isAbstract(modifiers))
            out.append("abstract ");
        else if (Modifier.isFinal(modifiers))
            out.append("final ");

        out.append("class ").append(underlyingClass.getName().replaceAll("\\.", "/"));
        if (underlyingClass.getTypeParameters().length > 0) {
            TypeVariable<?>[] types = underlyingClass.getTypeParameters();
            out.append("<");
            for (TypeVariable variable : types) {
                out.append(variable.toString()).append(":Ljava/lang/Object;");
            }
            out.append(">Ljava/lang/Object;");
        }
        return out.toString();
    }

}
