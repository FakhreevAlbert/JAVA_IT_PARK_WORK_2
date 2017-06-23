package ArrayList;


public class ArrayList {
    // поле, таким образом
    // каждый экземпляр ArrayList
    // будет иметь свой count
   private int count;

    // поле хранилище элементов
    private int elements[];

    public ArrayList() {
        this.elements = new int[10];
    }

    public void addToEnd(int value) {
        addToIndex(value, count);
    }

    public void addToBegin(int value) {
        addToIndex(value, 0);
    }

    public void addToIndex(int value, int index) {
        // делаем свдиг вправо, начиная с конца (count)
        // пока не дойдем до индекса, куда ходим добавить элемент
        for (int i = count; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // добавляем значение в нужный индекс
        elements[index] = value;
        count++;
    }

    public void removeByIndex(int index) {
        // делаем сдвиг влево, начиная от элемента, который хотим удалить
        for (int i = index; i < count -1; i++) {
            elements[i] = elements[i + 1];
        }
        // уменьшаем количество элементов
        count--;
    }

    public void removeByValue(int value) {
        // получили индекс удаляемого элемента
        int indexOfRemoved = indexOf(value);
        // удалили по индексу
        removeByIndex(indexOfRemoved);
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int get(int index) {
        return elements[index];
    }

    public int getCount() {
        return count;
    }

    public static ArrayList concat(ArrayList a, ArrayList b) {
        ArrayList result = new ArrayList();
        for(int i = 0; i < a.count; i++) {
            result.addToEnd(a.get(i));
        }

        for(int i = 0; i < b.count; i++) {
            result.addToEnd(b.get(i));
        }

        return result;
    }



    public static void addIfEquals(ArrayList a, ArrayList b, ArrayList c) {

        for (int j = 0; j < 5; j++) {

            for (int y = 0; y < 5; y++) {
                if (a.get(j) == b.get(y)) {
                    c.addToBegin(a.get(j));


                }
            }
        }

    }







}








