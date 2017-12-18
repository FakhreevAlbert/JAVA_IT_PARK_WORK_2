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
    private int num;


    public Meta() {

    }




    @Test
    private void show(String str, int num) {
        System.out.println("Test " + str + " " + num);
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
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(field -> field.isAnnotationPresent(Inject.class))
                            .forEach(field -> field.setAccessible(true));
                    try {
                        method.invoke(clazz.newInstance(),"Hello", 10);



                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                });












    }
}


