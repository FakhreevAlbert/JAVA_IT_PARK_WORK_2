class Program2 {

public static void main(String args[]) {
        int a[] = {2, -5, 6, -9, 1, 7};
        int i = 0;
        int j = 0;
        for (i = a.length - 1; i >= 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
          
        }
for (i = 0; i < a.length; i++) {
          System.out.println(a[i]);
          }
}
}