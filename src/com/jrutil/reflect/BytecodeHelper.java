package com.jrutil.reflect;

public class BytecodeHelper {

    protected static String getNameForType(String name) {
        StringBuilder out = new StringBuilder();
        if (name.equals("int"))
            out.append("I");
        else if (name.equals("long"))
            out.append("L");
        else if (name.equals("short"))
            out.append("S");
        else if (name.equals("byte"))
            out.append("B");
        else if (name.equals("char"))
            out.append("C");
        else if (name.equals("float"))
            out.append("F");
        else if (name.equals("double"))
            out.append("D");
        else if (name.equals("boolean"))
            out.append("Z");
        else
            out.append("L").append(name.replaceAll("\\.", "/")).append(";");
        return out.toString();
    }


}
