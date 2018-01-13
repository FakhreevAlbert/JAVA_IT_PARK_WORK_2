import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{            }

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Inject{}


public class Meta {
    @Inject
    private String str;
    @Inject
    private String num;


    public Meta() {

    }




    @Test
    private void show() {
        System.out.println("Test " + str.length() + " " + num.length());
    }

    void go() {
        System.out.println("No Test");
    }


    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Meta meta = new Meta();
        Class<?> clazz = Meta.class;
/*
        Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .forEach(field -> {field.setAccessible(true);
                    try {
                        field = meta.getClass().getDeclaredField("words");
                        field.set(meta, "New word");
                        field = meta.getClass().getDeclaredField("number");
                        field.set(meta, 4);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                });
*/
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .forEach(method -> {
                    method.setAccessible(true);
//                    Arrays.stream(clazz.getDeclaredFields())
//                            .filter(field -> field.isAnnotationPresent(Inject.class))
//                            .forEach(field -> field.setAccessible(true));
                    try {
                        Object instance = clazz.newInstance();
                        Arrays.stream(clazz.getDeclaredFields())
                                .filter(field -> field.isAnnotationPresent(Inject.class))
                                .forEach(field -> {
                                    field.setAccessible(true);
                                    try {
                                        field.set(instance, field.getType().newInstance());
                                    } catch (IllegalAccessException | InstantiationException e) {
                                        e.printStackTrace();
                                    }
                                });
                        method.invoke(instance);

                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                });












    }
}


