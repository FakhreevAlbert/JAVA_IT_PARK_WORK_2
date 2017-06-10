import java.io.*;


public class Main {

    public static void main(String[] args) {
        FileOutputStream set = null;
        String str = "Hot";
        try {
            set = new FileOutputStream("input.txt");
            set.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}