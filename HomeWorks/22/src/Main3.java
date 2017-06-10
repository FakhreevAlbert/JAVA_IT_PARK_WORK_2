import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 15.05.17.
 */
public class Main3 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String array[] = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter");
            array[i] = scanner.nextLine();
        }
        for (int j = 0; j < 3; j++) {
            System.out.println(array[j]);
        }
        
    }
}
