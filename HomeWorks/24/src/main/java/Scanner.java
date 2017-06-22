import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Scanner {

        private InputStream input;
        public String fileName;

        public Scanner(InputStream input, String fileName) {
            this.input = input;
            this.fileName = fileName;
        }

        public void nextInt() throws IOException {
            InputStream input = new FileInputStream(fileName);
            byte bytes[] = new byte[20];
            int integers[] = new int[20];
            int bytesCount = input.read(bytes);
            System.out.println(bytesCount);
            System.out.println(Arrays.toString(bytes));
            for (int i = 0; i < bytesCount; i++) {
                if (bytes[i] > 47 && bytes[i] < 58) {
                    integers[i] = bytes[i] - 48;

                    System.out.println(integers[i]);


                }



            }
        }
    }


