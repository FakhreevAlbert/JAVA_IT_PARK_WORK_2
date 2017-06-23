package LocMax;


import java.util.Scanner;

public class LocMax {
    public static void main(String[] args) {
        int locMax = 0;
       Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов массива: ");
        int a = scanner.nextInt();
        int [] c = new int[a];
        for (int i = 0; i < c.length;i++){
            System.out.println("Введите значение: ");
            c[i] = scanner.nextInt();
        }

            for (int i = 1; i < c.length; i++){

                if (c[i] > c[i-1] && c[i] > c[i+1] ){
                    locMax++;
            }



        }
        System.out.println("Колличество локальных максимумов: " + locMax);

    }
}
