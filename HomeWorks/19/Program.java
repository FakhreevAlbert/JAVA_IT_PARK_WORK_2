class  Program {
    public  static void main(String args[]){
        int x = 3231;
        int a = x / 1000;
        int a1 = x % 1000;
        int b = a1 / 100;
        int b1 = a1 % 100;
        int c = b1 / 10;
        int c1 = b1 % 10;
        int d = c1 / 1;
        char dig0;
        char dig1;
        char dig2;
        char dig3;
        dig0 = (char)(a + '0');
        dig1 = (char)(b + '0');
        dig2 = (char)(c + '0');
        dig3 = (char)(d + '0');
        char dig = ',';
        char z[] = {dig0, dig, dig1, dig, dig2, dig, dig3};
        for (int i = 0; i < z.length; i++){
            System.out.print(z[i]);
        }

    }
}