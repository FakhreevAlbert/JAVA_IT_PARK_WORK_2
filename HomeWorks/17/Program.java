public class Main6 {
    public static void main(String[] args) {

        int a[] = {4, 7, 2, -3, 5};
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){

                if (a[j] > a[i]){
                   int temp = a[j];
                   a[j] = a[i];
                   a[i] = temp;

                }

            }


        }
        for (int c = 0; c < a.length; c++){
            System.out.println(a[c]);
        }

    }
}
