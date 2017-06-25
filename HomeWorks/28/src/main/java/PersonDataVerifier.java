import java.util.Scanner;

public class PersonDataVerifier {
    Scanner scanner = new Scanner(System.in);

    public void enterName ()  {

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        if (!Character.isUpperCase(name.charAt(0))) {


            System.out.println("Имя введено не верно, повторите попытку!");
            enterName();
        } else {
            System.out.println("Имя введено корректно");

        }
    }

    public void enterSurname() {
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();

        if (!Character.isUpperCase(surname.charAt(0))) {
            System.out.println("Фамилия введена не верно, повторите попытку!");
            enterSurname();

        } else {
            System.out.println("Фамилия введена корректно");
        }

    }
}

