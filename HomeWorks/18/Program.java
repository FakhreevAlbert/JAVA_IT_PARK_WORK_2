class Program {
     public static void main(String args[]) {
          char c[] = {'3', '2', '3', '1'};
           
          int x0 = c[0] - '0';
          int x1 = c[1] - '0';
          int x2 = c[2] - '0';
          int x3 = c[3] - '0';
         int res = x0 * 1000 + x1 * 100 + x2 * 10 + x3 * 1; 
        
          System.out.println(res);
          
           
          
     }
}