class Program {
public static void main(String args[]) {
    int temp;
    int j;
    int a[] = {4, -5, 8, 2, -7, 3};
    int i = 0;
    for(i = 0; i < a.length - 1; i++){
        if (a[i] > a[i + 1]) {
           temp = a[i + 1];
           a[i + 1] = a[i];      
           j = i;
               while (j > 0 && temp < a[j - 1]) {
               a[j] = a[j - 1];               
               j--;
           }
           a[j] = temp;             
          }  

          }


          for (i = 0; i < a.length; i++) {
          System.out.println(a[i]);
        
           }  


    
    }


}