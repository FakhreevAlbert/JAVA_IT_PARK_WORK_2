public class Main7 {
    public static void main(String[] args) {

        int a[] = {4, 7, 2, -3, 5};
        int j = 0;
        int i = a.length;

            while (j < i){

                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
                if (j < (i - 1)){
                    j++;
                }
                if (j == (i - 1)){
                    j=0;
                    i--;
                }

            }

        for (int c = 0; c < a.length; c++){
            System.out.println(a[c]);
        }

    }
}