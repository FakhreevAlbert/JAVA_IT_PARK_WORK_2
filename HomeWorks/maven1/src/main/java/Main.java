

import dao.ApartmentDao;
import dao.ApartmentDaoJdbcTemplateImpl;
import dao.HumanDao;
import dao.HumanDaoJdbcTemplateImpl;
import models.Apartment;
import models.Human;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Main {
       public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/FAKHREEV_BD");
        dataSource.setUsername("postgres");
        dataSource.setPassword("J8PFekZS");
           HumanDao humanDao = new HumanDaoJdbcTemplateImpl(dataSource);
           ApartmentDao apartmentDao = new ApartmentDaoJdbcTemplateImpl(dataSource);
           Apartment apartment = new Apartment(68, 39, 6);





    }

    }

