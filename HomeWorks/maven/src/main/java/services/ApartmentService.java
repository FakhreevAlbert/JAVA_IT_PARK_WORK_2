package services;


import dao.ApartmentDao;
import dao.HumanDao;
import models.Apartment;
import models.Human;

public class ApartmentService {

    private HumanDao humanDao;
    private ApartmentDao apartmentDao;

    public ApartmentService(HumanDao humanDao, ApartmentDao apartmentDao) {
        this.humanDao = humanDao;
        this.apartmentDao = apartmentDao;
    }

    public void addApartmentToHuman(Apartment apartment){
        int humanId = apartment.getOwnerId();
        if (humanDao.isExistById(humanId)){
            apartmentDao.save(apartment);

        }else {
            System.err.println("Human not found");
        }
    }
}
