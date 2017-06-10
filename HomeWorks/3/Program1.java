import java.util.Scanner;

class Program1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
                System.out.println("¬ведите первое число: ");
		int a = scanner.nextInt();

                System.out.println("¬ведите второе число: ");
		int b = scanner.nextInt();


                System.out.println("¬ведите третье число: ");
		int c = scanner.nextInt();

                int d= (a + b + c);
                System.out.println("—умма введенных чисел равна: " + d);
		
		
	}
}