

public class Waiter {
    private String name;
    private String RestaurantName;


    public Waiter( String name, String restaurantName) {
        RestaurantName = restaurantName;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public  void welcome () {
        System.out.println("Добрый вечер, меня зовут "+ name +" я рад приветствовать Вас, в изысканном ресторане высокой авторской, итальянской кухни " + RestaurantName + "!");

    }

    public void order() {
        System.out.println("Сегодня наше меню включает: 1)Pizza, 2)Shaurma, 3)Donner, 4)Soup, 5)Pepsi, 6)Tea, 7)Coffe, 8)Snickers");

    }

}
