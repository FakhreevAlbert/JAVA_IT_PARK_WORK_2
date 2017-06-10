
public class Main {
    public static void main(String[] args) {
        Waiter myWaiter = new Waiter("Карен","LapunteMendeDeLaNochi");
        Purse myPurse = new Purse(1400);
        Score myScore = new Score(560, 150, 200, 250, 50, 25, 110, 80);
        myWaiter.welcome();
        myWaiter.order();
        myScore.go();
        if (myPurse.many < myScore.total){
            System.err.println("У вас недостаточно средств, чтобы сделать заказ, повторите попытку!");
            myScore.go();
        }
        else {myScore.go2();}


    }

}
