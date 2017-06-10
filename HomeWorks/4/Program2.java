import java.util.Scanner;

class Program2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
                System.out.println("¬ведите первое число: ");
		int a = scanner.nextInt();

                System.out.println("¬ведите второе число: ");
		int b = scanner.nextInt();


                int d= (a / b);
                System.out.println("„астное введенных чисел равна: " + d);
		
		
	}
}