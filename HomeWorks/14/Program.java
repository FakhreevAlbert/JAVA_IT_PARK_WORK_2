class Program {
      public static void main(String args[]) {
            double a[] = {5, 2, 1, 5, 6, 7};
            double x = 0;
            double middle;
            for (int i = 0; i < a.length; i++) {
            x = x + a[i];
                 }
            middle = x / a.length;
            System.out.println(middle);
           }
}