package dao;

import mappers.RowMapper;
import models.Human;
import utils.FileDaoTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HumanDaoFileBasedImpl implements HumanDao{

    private String fileName;

    private FileDaoTemplate template;

    public HumanDaoFileBasedImpl(String fileName, FileDaoTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }
    private RowMapper<Human>humanRowMapper = new RowMapper<Human>() {
        @Override
        public Human mapRow(String row) {
            String data[] = row.split(" ");
            return new Human(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2]
            );
        }
    };

    @Override
    public int save(Human human) {



        return 0;
    }

    @Override
    public Human find(int id) {

        return template.findByValue(fileName,0,id,humanRowMapper).get(0);
    }

    @Override
    public void update(Human model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Human> findAll() {
        List<Human> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine!=null){
                String data[]= currentLine.split(" ");
                Human founded = humanRowMapper.mapRow(currentLine);
                result.add(founded);
                currentLine = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean isExistById(int humanId) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();

            while (currentLine != null){
                String lineAsArray[] = currentLine.split(" ");
                String humanIdFromFileAsString = lineAsArray[0];
                int humanIdFromFileAsInt = Integer.parseInt(humanIdFromFileAsString);
                if (humanId == humanIdFromFileAsInt){
                    return true;
                }
                currentLine = reader.readLine();
            }
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Human> findByName(String name) {
        return template.findByValue(fileName,1,name,humanRowMapper);
    }

    @Override
    public List<Human> findBySurname(String surname) {
        return template.findByValue(fileName,2,surname,humanRowMapper);
    }


}
