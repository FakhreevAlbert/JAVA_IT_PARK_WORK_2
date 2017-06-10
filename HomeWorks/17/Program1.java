import java.util.Scanner;
     class Program1 {
          public static void main(String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter number: ");
                int x = scanner.nextInt();
                int i = 0;
                int a = 0;
                int b = 0;
             while (i < x) {
              System.out.println("¬ведите число: ");
              int y = scanner.nextInt();
              
              if (a < y) {
               a = y;

             }
            System.out.println(a);
            System.out.println(b);
          }
     }
                