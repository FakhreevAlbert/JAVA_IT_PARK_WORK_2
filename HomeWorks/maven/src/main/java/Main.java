import dao.ApartmentDao;
import dao.ApartmentDaoFileBasedImpl;
import dao.HumanDao;
import dao.HumanDaoFileBasedImpl;
import exceptions.HumanOrApartmenIsNotFound;
import generators.IdGenerator;
import generators.IdGeneratorImpl;
import models.Apartment;
import models.Human;
import utils.FileDaoTemplate;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human human = new Human(2, "Afanasij","Fet");
        Apartment apartment = new Apartment(1,63,78,1);

        IdGenerator idGenerator = new IdGeneratorImpl("apartment_ids.txt","human_ids.txt");
        FileDaoTemplate template = new FileDaoTemplate(human,apartment,"humans.txt","apartments.txt",idGenerator);

        HumanDao humanDao = new HumanDaoFileBasedImpl("humans.txt",template);
        ApartmentDao apartmentDao = new ApartmentDaoFileBasedImpl("apartments.txt",idGenerator,template);



        humanDao.findByName("Egor");
        apartmentDao.find(4);

    }

}