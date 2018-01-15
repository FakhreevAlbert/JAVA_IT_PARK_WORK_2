
import java.lang.reflect.*;
import java.util.LinkedList;

    public class Main {
        public static void main(String[] args) {
            Class<?> clazz = LinkedList.class;

            String className = clazz.getSimpleName();
            System.out.println("Class name: " + className);

            while (!clazz.equals(java.lang.Object.class)) {
                clazz = clazz.getSuperclass();
                System.out.println(clazz.getName());
            }
            if (true) {
                return;
            }

            String superClassName = clazz.getSuperclass().getName();
            System.out.println("Super class: " + superClassName);
            superClassName = clazz.getSuperclass().getSuperclass().getName();
            System.out.println("Super class: " + superClassName);
            superClassName = clazz.getSuperclass().getSuperclass().getSuperclass().getName();
            System.out.println("Super class: " + superClassName);
            superClassName = clazz.getSuperclass().getSuperclass().getSuperclass().getSuperclass().getName();
            System.out.println("Super class: " + superClassName);



            System.out.println("Methods:");

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print(method.getName());
                System.out.println(" " + Modifier.toString(method.getModifiers()));
            }
            int countMethods = methods.length;
            System.out.println("Total:" + countMethods);


            System.out.println("Fields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.print(field.getName());
                System.out.println(" " + Modifier.toString(field.getModifiers()));
            }
            int countFields = fields.length;
            System.out.println("Total: " + countFields);


            Class[] classes = clazz.getClasses();
            for (Class innerClassName : classes) {
                System.out.println("Classws an interfaces: " + innerClassName.getSimpleName());
            }


        }

    }




