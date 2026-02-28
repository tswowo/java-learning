package mysimpleframework;

import java.lang.reflect.*;

public class MyFrameWorkTest1 {
    public static void main(String[] args) {
        ObjectInspector.inspectObject("hello");
    }
}

class ObjectInspector {

    /**
     * 打印对象的所有字段和方法信息，包含访问修饰符
     * @param obj 要检查的对象
     */
    public static void inspectObject(Object obj) {
        Class<?> clazz = obj.getClass();

        // 输出所有字段信息，包含访问修饰符
        System.out.println("Fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String modifierName=getModifierString(field.getModifiers());
            String typeName=field.getType().getName();
            String fieldName=field.getName();
            System.out.println(modifierName+" "+typeName+" "+fieldName);
        }

        // 输出所有方法信息，包含访问修饰符
        System.out.println("\nMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String modifierName=getModifierString(method.getModifiers());
            String returnTypeName=method.getReturnType().getSimpleName();
            String methodName=method.getName();
            System.out.print(modifierName+" "+returnTypeName+" "+methodName+"(");

            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0) System.out.print(", ");
                Parameter parameter = parameters[i];
                String parameterTypeName = parameter.getType().getName();
                String parameterName = parameter.getName();
                System.out.print(parameterTypeName+" "+parameterName);
            }
            System.out.println(")");
        }
    }

    /**
     * 根据修饰符值返回对应的字符串表示
     * @param modifiers 修饰符值
     * @return 修饰符字符串
     */
    private static String getModifierString(int modifiers) {
        StringBuilder sb = new StringBuilder();

        if (Modifier.isPublic(modifiers)) {
            sb.append("public ");
        } else if (Modifier.isPrivate(modifiers)) {
            sb.append("private ");
        } else if (Modifier.isProtected(modifiers)) {
            sb.append("protected ");
        }

        if (Modifier.isStatic(modifiers)) {
            sb.append("static ");
        }

        if (Modifier.isFinal(modifiers)) {
            sb.append("final ");
        }

        return sb.toString();
    }
}
