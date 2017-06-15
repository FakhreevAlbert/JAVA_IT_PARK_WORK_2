import dao.ApartmentDao;
import dao.ApartmentDaoFileBasedImpl;
import dao.HumanDao;
import dao.HumanDaoFileBasedImpl;
import generators.IdGenerator;
import generators.IdGeneratorImpl;
import models.Apartment;
import models.Human;
import utils.FileDaoTemplate;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human human = new Human(1, "Egor","Creed");
        Apartment apartment = new Apartment(1,63,78,1);

        IdGenerator idGenerator = new IdGeneratorImpl("apartment_ids.txt","human_ids.txt");
        FileDaoTemplate template = new FileDaoTemplate("humans.txt","apartments.txt");



        HumanDao humanDao = new HumanDaoFileBasedImpl("humans.txt",template);
        ApartmentDao apartmentDao = new ApartmentDaoFileBasedImpl("apartments.txt",null,template);



        Human human1 = humanDao.find(1);
        System.out.println(human1.getName());
        Apartment apartment1 = apartmentDao.find(1);
        System.out.println(apartment1.getNumber());
        List<Human> humans = humanDao.findByName("Альберт");
        System.out.println(humans);
        List<Human> humans1 = humanDao.findBySurname("Чан");
        System.out.println(humans1);
        List<Apartment> apartments = apartmentDao.findAll();
        System.out.println(apartments);
        List<Human> humans2 = humanDao.findAll();
        System.out.println(humans2);


    }

}