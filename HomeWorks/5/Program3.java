import java.util.Scanner;

class Program3 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
                System.out.println("Введите первое число: ");
		int a = scanner.nextInt();

                System.out.println("Введите второе число: ");
		int b = scanner.nextInt();


                int d= (a % b);
                System.out.println("Остаток деления чисел равен: " + d);
		
		
	}
}