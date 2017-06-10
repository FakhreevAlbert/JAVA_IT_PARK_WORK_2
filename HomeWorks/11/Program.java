import java.util.Scanner;
class Program {
              public static void main(String args[]) {
                     Scanner scanner = new Scanner(System.in);
                     System.out.print("Введите количество значений: ");
                     int x = scanner.nextInt();
                     int i = 0;
                     int max = 0;
              while (i < x) {
                System.out.println("Введите значение: ");
                int a = scanner.nextInt();
              if (a >= max) {
                 max = a; 
                     }
                i++;
                }
               System.out.print("Максимальное значение: " + max);
         }
}
                     
