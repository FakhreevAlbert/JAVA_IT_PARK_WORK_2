package ArrayList;




public class Main8 {
    public static void main(String[] args) {

        ArrayList a = new ArrayList();
        a.addToBegin(5);
        a.addToBegin(7);
        a.addToBegin(2);
        a.addToBegin(6);
        a.addToBegin(1);

        ArrayList b = new ArrayList();
        b.addToBegin(1);
        b.addToBegin(8);
        b.addToBegin(2);
        b.addToBegin(7);
        b.addToBegin(5);

        ArrayList c = new ArrayList();
        ArrayList.addIfEquals(a,b,c);






        for (int i = 0; i < 5; i++){
            System.out.print(a.get(i));

        }
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            System.out.print(b.get(i));

        }
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            System.out.print(c.get(i));
        }


    }
}
