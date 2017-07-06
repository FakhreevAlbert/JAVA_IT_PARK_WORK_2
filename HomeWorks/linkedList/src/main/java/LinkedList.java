
public class LinkedList <T> {
    private Node<T> head;
    private Node<T> tail;

    private int count;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    private static class Node<T> {
        T element;
        Node<T> next;



        public Node(T element) {
            this.element = element;

        }

    }

    public void add(T element) {
        // создали новый узел связного списка
        Node<T> newNode = new Node<T>(element);
        if (count == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            // положили новый узел после последнего
            this.tail.next = newNode;
            // сделаем новый узел последним
            this.tail = newNode;
        }
        count++;
    }

    public void addToBegin(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.next = head;
        this.head = newNode;
        count++;
    }

    /**
     * Получение индекса элемента в списке через equals
     * @param element искомый элемент
     * @return порядковый номер в списке, если элемента
     * в списке нет - вернуть -1
     */

    public int indexOf(T element) {

            if (element.equals(head.element)) {
                return 0;

            }else if (element.equals(tail.element)){
                    return count -1;
            }
            int i = 0;
            Node<T> nextName = this.head;
            while (i < count -1) {
                if (element.equals(nextName.element)) {

                    return i;

                }else if (!element.equals(nextName.element)) {
                    nextName = nextName.next;
                    i++;

                }


            }

        return -1;
    }

    public void remove(T element) {
        Node<T> prevNode = null;
        Node<T> newNode = this.head;


            while (newNode != null) {
                if (newNode.element.equals(element)) {
                    if (prevNode != null){
                        prevNode.next = newNode.next;
                        if (newNode.next == null){
                            this.tail= prevNode;
                        }
                    }else {
                     this.head = this.head.next;
                     if (this.head == null){
                         this.tail = null;
                     }
                    }
                    count--;
                }
                prevNode = newNode;
                newNode = newNode.next;
            }
        }


    public void removeAt(int index) {
        Node<T> prevNode = null;
        Node<T> newNode = this.head;


        for (int i = 0; i < index; i++){
            if (i == index -1){


                if (prevNode != null){
                    prevNode.next = newNode.next;
                    if (newNode.next == null){
                        this.tail= prevNode;
                    }
                }else {
                    this.head = this.head.next;
                    if (this.head == null){
                        this.tail = null;
                    }
                }
                count--;
            }
            prevNode = newNode;
            newNode = newNode.next;
        }
    }






    public T get(int index) {
        if (index < count) {
            if (index == count -1) {
                return tail.element;
            } else if (index == 0) {
                return head.element;
            } else {
                Node<T> current = this.head;
                int i = 0;
                while (i < index) {
                    current = current.next;
                    i++;
                }

                return current.element;
            }
        } else {
            throw new IllegalArgumentException("Неверный индекс");
        }
    }
    public void show(){
        int i ;
        for (i = 0;i < count;i++){
            System.out.println(get(i));
        }

    }

}
