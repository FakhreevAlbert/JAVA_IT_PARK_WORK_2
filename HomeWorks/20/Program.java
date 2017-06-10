import java.util.Scanner;
public class Program {

    public static void main(String args[]) {


        char text[] = new char[100];
        char word[] = new char[10];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            System.out.println("Enter text: ");
            char x = scanner.next().charAt(0);
            text[i] = x;
        }
        System.out.println("Enter number: ");
        int d = scanner.nextInt();
        for (int k = 0; k < d; k++) {
            System.out.println("Enter word: ");
            char y = scanner.next().charAt(0);
            word[k] = y;
        }
        for (int j = 0; j < c; j++) {
            System.out.println("text: " + text[j]);

        }
        for (int z = 0; z < d; z++){
            System.out.println("word: " + word[z]);

        }
        int m = 0;
        for (int q = 0; q < c; q++){
            for (int v = 0; v < d; v++){
            if (text[q] == word[v]){
                m++;
            }

            }

        }
        System.out.print("Total: "+ m);
    }
}