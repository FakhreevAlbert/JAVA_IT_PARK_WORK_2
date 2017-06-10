import java.util.Scanner;
public class Score {


    int Pizza;
    int Shaurma;
    int Donner;
    int Soup;
    int Pepsi;
    int Tea;
    int Coffee;
    int Snickers;
    Scanner scanner = new Scanner(System.in);

    public Score(int pizza, int shaurma, int donner, int soup, int pepsi, int tea, int coffee, int snickers) {

        Pizza = pizza;
        Shaurma = shaurma;
        Donner = donner;
        Soup = soup;
        Pepsi = pepsi;
        Tea = tea;
        Coffee = coffee;
        Snickers = snickers;
    }

    int total = 0;


    public void go() {
        System.out.println("Какое количество блюд вы будeтe заказывать?");
        int x = scanner.nextInt();
        int eats[] = new int[x];
        int order[] = new int[x];
        for (int i = 0; i < x; i++) {
            System.out.println("Назовите наименование блюда: ");
            eats[i] = scanner.nextInt();

            if (eats[i] == 1) {
                order[i] = Pizza;
            }
            if (eats[i] == 2) {
                order[i] = Shaurma;
            }
            if (eats[i] == 3) {
                order[i] = Donner;
            }
            if (eats[i] == 4) {
                order[i] = Soup;
            }
            if (eats[i] == 5) {
                order[i] = Pepsi;
            }
            if (eats[i] == 6) {
                order[i] = Tea;
            }
            if (eats[i] == 7) {
                order[i] = Coffee;
            }
            if (eats[i] == 8) {
                order[i] = Snickers;
            }
            total = total + order[i];

        }


    }

    public void go2() {
        System.out.println("Спасибо за заказ сумма вашего заказа состоявляет: " + total);

    }
}
