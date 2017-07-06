
public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Marsel");
        linkedList.add("Alina");
        linkedList.add("Regina");
        linkedList.add("Rinata");
        linkedList.add("Alesya");
        linkedList.add("Elena");
        linkedList.add("Albert");

       linkedList.addToBegin("Ivan");

       //String fromList = linkedList.get(2);
      // System.out.println(fromList);

      // System.out.println(linkedList.indexOf("Alina"));
        //linkedList.remove("Ivan");
        linkedList.removeAt(6);

        linkedList.show();
    }
}
