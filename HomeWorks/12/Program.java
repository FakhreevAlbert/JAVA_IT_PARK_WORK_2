import java.util.Scanner;
class Program {
      public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("������� ���������� ��������: ");
            int x = scanner.nextInt();
            int i = 0;
            double sum = 0;
            double middle;
      while (i < x) {
            System.out.println("������� ��������: ");
            double a = scanner.nextInt();
            sum = sum + a;
            i++;
                    }
            
            middle = sum / x;
            System.out.print("������� �������������� �������� = " + middle);
             }
}
            