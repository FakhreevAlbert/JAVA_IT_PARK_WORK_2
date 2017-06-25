package utils;


import exceptions.HumanOrApartmenIsNotFound;
import generators.IdGenerator;
import mappers.RowMapper;
import models.Apartment;
import models.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDaoTemplate {
    public Human human;
    public Apartment apartment;
    public String fileNameHuman;
    public String fileNameApartment;
    public IdGenerator idGenerator;

    public FileDaoTemplate(Human human, Apartment apartment, String fileNameHuman, String fileNameApartment, IdGenerator idGenerator) {
        this.human = human;
        this.apartment = apartment;
        this.fileNameHuman = fileNameHuman;
        this.fileNameApartment = fileNameApartment;
        this.idGenerator = idGenerator;
    }



    public <T> List<T> findByValue(String filename, int valueColumn, Object value, RowMapper<T> rowMapper)   {
        List<T> result = new ArrayList<T>();
        String object;
        if (filename.equals("humans.txt")){
            object = "Жители";

        }else {
            object = "Квартиры";
        }
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String data[] = currentLine.split(" ");
                String interestingValue = data[valueColumn];
                String inputValue = value.toString();
                if (interestingValue.equals(inputValue)) {
                    T founded = rowMapper.mapRow(currentLine);
                    result.add(founded);
                }
                currentLine = reader.readLine();


                }
                if (result.size() == 0){
                throw new HumanOrApartmenIsNotFound(object + " по запросу: " + value + " не найдены");
                }





        } catch (FileNotFoundException e) {
          e.getMessage();
       } catch (IOException e) {
           e.getMessage();
       }

        System.out.println(result);
        return result;


    }
    public int saveHuman(IdGenerator idGenerator) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameHuman, true));
            int newHumanId = idGenerator.generateForHuman();
            human.setId(newHumanId);
            human.toString();

            String humanAsString = human.getId()
                    + " " + human.getName()
                    + " " + human.getSurname();
            writer.write(humanAsString + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } return 0;
    }
    public int saveApartment(IdGenerator idGenerator){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameApartment,true));
            int newApartmentId = idGenerator.generateForApartment();
            apartment.setId(newApartmentId);
            apartment.toString();
            String apartmentAsString = apartment.getId()
                    + " " + apartment.getNumber()
                    + " " + apartment.getArea()
                    + " " + apartment.getOwnerId();
            writer.write(apartmentAsString + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }return 0;
    }




}
