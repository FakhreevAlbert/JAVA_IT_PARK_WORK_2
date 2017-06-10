import java.util.Scanner;
     class Program {
           public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ENTER NUMBER: ");
            int a = scanner.nextInt();
            int i = 0;
      while (i < a) {
                     System.out.println(i);
                     i = i + 2;
                     }
       }
}