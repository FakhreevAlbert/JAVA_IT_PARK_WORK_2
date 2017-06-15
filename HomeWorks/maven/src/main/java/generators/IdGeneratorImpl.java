package generators;


import java.io.*;

public class IdGeneratorImpl implements IdGenerator {
    private int lastApartmentId;
    private int lastHumanId;

    private String apartmentIdFileName;
    private String humanIdFileName;

    public IdGeneratorImpl(String apartmentIdFileName, String humanIdFileName) {
        this.apartmentIdFileName = apartmentIdFileName;
        this.humanIdFileName = humanIdFileName;


        try {
            BufferedReader apartmentReader = new BufferedReader(new FileReader(apartmentIdFileName));

            lastApartmentId = Integer.parseInt(apartmentReader.readLine());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader humanReader = new BufferedReader(new FileReader(humanIdFileName));
            lastHumanId = Integer.parseInt(humanReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int generateForHuman() {
        int newHumanId = lastHumanId + 1;
        try {
            BufferedWriter humanWriter = new BufferedWriter(new FileWriter(humanIdFileName));
            humanWriter.write(newHumanId + "");
            humanWriter.close();
            lastHumanId = newHumanId;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newHumanId;
    }

    public int generateForApartment() {
        int newId = lastApartmentId + 1;

        try {
            BufferedWriter apartmentWriter = new BufferedWriter(new FileWriter(apartmentIdFileName));
            apartmentWriter.write(newId + "");
            apartmentWriter.close();
            lastApartmentId = newId;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newId;
    }
}
