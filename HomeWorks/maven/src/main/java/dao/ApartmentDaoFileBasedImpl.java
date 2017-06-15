package dao;

import generators.IdGenerator;
import mappers.RowMapper;
import models.Apartment;
import utils.FileDaoTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ApartmentDaoFileBasedImpl implements ApartmentDao {
    private String fileName;
    private IdGenerator idGenerator;
    private FileDaoTemplate template;

    public ApartmentDaoFileBasedImpl(String fileName, IdGenerator idGenerator, FileDaoTemplate template) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
        this.template = template;
    }

    public int save(Apartment apartment) {

        return 0;
    }

    private RowMapper<Apartment> apartmentRowMapper = new RowMapper<Apartment>() {
        @Override
        public Apartment mapRow(String row) {
            String data[] = row.split(" ");
            return new Apartment(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]));

        }
    };

    public Apartment find(int id) {
        return template.findByValue(fileName,0,id,apartmentRowMapper).get(0);
    }

    public void update(Apartment model) {

    }

    public void delete(int id) {

    }

    public List<Apartment> findAll() {
        List<Apartment> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine != null){

                Apartment founded = apartmentRowMapper.mapRow(currentLine);
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
    public List<Apartment> findByNumber(String number) {
        return template.findByValue(fileName,1,number,apartmentRowMapper);
    }

    @Override
    public List<Apartment> findByArea(String area) {
        return template.findByValue(fileName,2,area,apartmentRowMapper);
    }
}
