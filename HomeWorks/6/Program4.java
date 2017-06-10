import java.util.Scanner;

class Program4 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
                System.out.println("¬ведите число: ");
		int a = scanner.nextInt();
int b = a / 128;
int b1 = a % 128;
int c = b1 / 64;
int c1 = b1 % 64;
int d = c1 / 32;
int d1 = c1 % 32;
int e = d1 / 16;
int e1 = d1 % 16;
int f = e1 / 8;
int f1 = e1 % 8;
int g = f1 / 4;
int g1 = f1 % 4;
int h = g1 / 2;
int h1 = g1 % 2;
int i = h1 / 1;
int i1 = h1 % 1;
System.out.println("¬веденное число в двоичной системе: " + b + c + d + e + f + g + h + i);


                
		
		
	}
}